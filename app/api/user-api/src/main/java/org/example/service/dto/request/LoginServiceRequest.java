package org.example.service.dto.request;

import lombok.Builder;
import org.example.dto.request.LoginDomainRequest;
import org.example.entity.User;
import org.example.vo.RandomNickname;
import org.example.vo.SocialLoginApiType;

@Builder
public record LoginServiceRequest(
    SocialLoginApiType socialLoginType,
    String identifier,
    String fcmToken
) {

    public User createUser() {
        return User.builder()
            .nickname(RandomNickname.makeRandomNickName())
            .fcmToken(fcmToken)
            .build();
    }

    public LoginDomainRequest toDomainRequest() {
        return LoginDomainRequest.builder()
            .socialLoginType(socialLoginType.toDomainType())
            .identifier(identifier)
            .fcmToken(fcmToken)
            .build();
    }
}
