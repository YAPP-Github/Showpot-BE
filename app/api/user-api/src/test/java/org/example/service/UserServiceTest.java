package org.example.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;
import java.util.NoSuchElementException;
import org.example.entity.SocialLogin;
import org.example.entity.User;
import org.example.fixture.UserFixture;
import org.example.fixture.dto.UserRequestDtoFixture;
import org.example.security.dto.UserParam;
import org.example.security.token.JWTGenerator;
import org.example.security.token.TokenProcessor;
import org.example.usecase.ArtistSubscriptionUseCase;
import org.example.usecase.GenreSubscriptionUseCase;
import org.example.usecase.InterestShowUseCase;
import org.example.usecase.TicketingAlertUseCase;
import org.example.usecase.UserUseCase;
import org.example.vo.SocialLoginApiType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.springframework.transaction.support.TransactionTemplate;

public class UserServiceTest {

    private final UserUseCase userUseCase = mock(UserUseCase.class);
    private final ArtistSubscriptionUseCase artistSubscriptionUseCase = mock(ArtistSubscriptionUseCase.class);
    private final GenreSubscriptionUseCase genreSubscriptionUseCase = mock(GenreSubscriptionUseCase.class);
    private final InterestShowUseCase interestShowUseCase = mock(InterestShowUseCase.class);
    private final TicketingAlertUseCase ticketingAlertUseCase = mock(TicketingAlertUseCase.class);
    private final JWTGenerator jwtGenerator = mock(JWTGenerator.class);
    private final TokenProcessor tokenProcessor = mock(TokenProcessor.class);
    private final TransactionTemplate transactionTemplate = mock(TransactionTemplate.class);

    private final UserService userService = new UserService(
        userUseCase,
        artistSubscriptionUseCase,
        genreSubscriptionUseCase,
        interestShowUseCase,
        ticketingAlertUseCase,
        jwtGenerator,
        tokenProcessor,
        transactionTemplate
    );

    @ParameterizedTest
    @EnumSource(
        value = SocialLoginApiType.class,
        names = {"KAKAO", "GOOGLE", "APPLE"},
        mode = Mode.INCLUDE
    )
    @DisplayName("로그인 시 사용자가 존재하지 않으면 새로운 사용자를 생성하고 JWT를 반환한다.")
    void getJwtAndCreatesNewUserIfNotExistWhenLogin(SocialLoginApiType type) {
        // given
        var request = UserRequestDtoFixture.loginServiceRequest(type);
        given(
            userUseCase.findUser(request.toDomainRequest())
        ).willThrow(
            NoSuchElementException.class
        );

        var user = UserFixture.randomNicknameUser();
        given(
            userUseCase.createNewUser(any(User.class), any(SocialLogin.class))
        ).willReturn(user);

        // when
        userService.login(request);

        // then
        verify(jwtGenerator, times(1)).generate(any(UserParam.class), any(Date.class));
    }

    @Test
    @DisplayName("로그인 시 사용자가 존재하면 기존의 사용자 정보로 JWT를 반환하다.")
    void getJwtAndUserIfExistWhenLogin() {
        // given
        var request = UserRequestDtoFixture.loginServiceRequest(SocialLoginApiType.KAKAO);
        var user = UserFixture.randomNicknameUser();
        given(
            userUseCase.findUser(request.toDomainRequest())
        ).willReturn(user);

        // when
        userService.login(request);

        // then
        verify(jwtGenerator, times(1)).generate(any(UserParam.class), any(Date.class));
    }
}
