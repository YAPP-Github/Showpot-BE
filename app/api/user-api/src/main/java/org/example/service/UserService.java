package org.example.service;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.UserProfileDomainResponse;
import org.example.entity.SocialLogin;
import org.example.entity.User;
import org.example.security.dto.TokenParam;
import org.example.security.dto.UserParam;
import org.example.security.token.JWTGenerator;
import org.example.security.token.TokenProcessor;
import org.example.service.dto.request.LoginServiceRequest;
import org.example.service.dto.response.UserProfileServiceResponse;
import org.example.usecase.UserUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserUseCase userUseCase;
    private final JWTGenerator jwtGenerator;
    private final TokenProcessor tokenProcessor;

    public TokenParam login(LoginServiceRequest loginServiceRequest) {
        User user = getUser(loginServiceRequest);
        var userParam = UserParam.from(user);

        return jwtGenerator.generate(userParam, new Date());
    }

    public void logout(UUID userId, String accessToken) {
        User user = userUseCase.findByIdOrElseThrow(userId);
        tokenProcessor.makeAccessTokenBlacklistAndDeleteRefreshToken(
            accessToken,
            user.getId()
        );
    }

    public void withdraw(UUID userId, String accessToken) {
        userUseCase.deleteUser(userId);
        tokenProcessor.makeAccessTokenBlacklistAndDeleteRefreshToken(
            accessToken,
            userId
        );
    }

    public TokenParam reissue(UUID userId, String refreshToken) {
        userUseCase.findByIdOrElseThrow(userId);
        return tokenProcessor.reissueToken(refreshToken);
    }

    public UserProfileServiceResponse findUserProfile(UUID userId) {
        UserProfileDomainResponse profile = userUseCase.findUserProfile(userId);

        return UserProfileServiceResponse.from(profile);
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
}
