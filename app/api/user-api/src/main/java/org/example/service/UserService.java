package org.example.service;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.entity.SocialLogin;
import org.example.entity.User;
import org.example.security.dto.TokenParam;
import org.example.security.dto.UserParam;
import org.example.security.token.JWTGenerator;
import org.example.security.token.RefreshTokenProcessor;
import org.example.service.dto.request.LoginServiceRequest;
import org.example.usecase.UserUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserUseCase userUseCase;
    private final JWTGenerator jwtGenerator;
    private final RefreshTokenProcessor refreshTokenProcessor;

    public TokenParam login(final LoginServiceRequest loginServiceRequest) {
        User user = getUser(loginServiceRequest);
        var userParam = UserParam.from(user);

        return jwtGenerator.generate(userParam, new Date());
    }

    public void logout(UUID userId) {
        refreshTokenProcessor.deleteRefreshToken(userId);
    }

    private User getUser(LoginServiceRequest request) {
        try {
            return userUseCase.findUser(request.toDomainRequest());
        } catch (NoSuchElementException e) {
            return createUser(request);
        }
    }

    private User createUser(LoginServiceRequest loginServiceRequest) {
        User user = loginServiceRequest.createUser();
        SocialLogin socialLogin = SocialLogin.builder()
            .socialLoginType(loginServiceRequest.socialLoginType().toDomainType())
            .identifier(loginServiceRequest.identifier())
            .userId(user.getId())
            .build();

        return userUseCase.createNewUser(user, socialLogin);
    }

    public String findNickname(final User user) {
        return userUseCase.findNickName(user);
    }
}
