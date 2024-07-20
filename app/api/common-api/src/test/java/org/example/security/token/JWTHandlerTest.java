package org.example.security.token;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import java.util.Date;
import java.util.UUID;
import org.example.exception.BusinessException;
import org.example.property.TokenProperty;
import org.example.repository.TokenRepository;
import org.example.security.dto.TokenParam;
import org.example.security.dto.UserParam;
import org.example.security.error.TokenError;
import org.example.vo.UserRoleApiType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("JWT 처리 테스트")
class JWTHandlerTest {

    TokenProperty tokenProperty = new TokenProperty(
        "ahRhwlglftmrkwkfehlaussksmsdjraksrmadmfqjfrjtdlrhdkwnwlflsmswlqdptjgodqhrgkrptkftndlTDmfrjtdlek",
        3600000L,
        1209600000L
    );
    TokenRepository tokenRepository = mock(TokenRepository.class);
    JWTHandler jwtHandler = new JWTHandler(tokenProperty);
    JWTGenerator jwtGenerator = new JWTGenerator(tokenProperty, tokenRepository);
    UserParam userParam = new UserParam(
        UUID.randomUUID(),
        UserRoleApiType.USER
    );

    @Test
    @DisplayName("토큰의 claim을 추출하면 유저 정보가 반환된다.")
    void extractClaim() {
        TokenParam token = jwtGenerator.generate(userParam, new Date());
        UserParam parsedUserParam = jwtHandler.extractUserFrom(token.accessToken());

        assertThat(parsedUserParam.userId()).isEqualTo(userParam.userId());
    }

    @Test
    @DisplayName("만료된 토큰에서 유저 정보를 추출하면 예외가 발생한다.")
    void makeExceptionParsingExpiredToken() {
        String expiredAccessToken = jwtGenerator.generate(
            userParam,
            new Date(new Date().getTime() - tokenProperty.accessTokenExpirationSeconds())
        ).accessToken();

        assertThatThrownBy(() -> jwtHandler.extractUserFrom(expiredAccessToken))
            .isInstanceOf(BusinessException.class)
            .hasMessage(TokenError.EXPIRED_TOKEN.getClientMessage());
    }

    @Test
    @DisplayName("유효하지 않은 토큰을 파싱하면 예외가 발생한다.")
    void makeExceptionParsingInvalidToken() {
        String invalidAccessToken = "invalidToken";

        assertThatThrownBy(() -> jwtHandler.extractUserFrom(invalidAccessToken))
            .isInstanceOf(BusinessException.class)
            .hasMessage(TokenError.INVALID_TOKEN.getClientMessage());
    }

    @Test
    @DisplayName("만료된 토큰에서 유저 아이디를 추출하면 유저 아이디가 반환된다.")
    void extractUserIdFromExpiredToken() {
        String expiredAccessToken = jwtGenerator.generate(
            userParam,
            new Date(new Date().getTime() - tokenProperty.accessTokenExpirationSeconds())
        ).accessToken();

        UUID extractedUserIdFromExpiredToken = jwtHandler.getUserIdFromExpiredToken(
            expiredAccessToken);
        assertThat(extractedUserIdFromExpiredToken).isEqualTo(userParam.userId());
    }
}