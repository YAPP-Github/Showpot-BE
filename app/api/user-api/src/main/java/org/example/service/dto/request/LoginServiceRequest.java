package org.example.service.dto.request;

import lombok.Builder;
import org.example.entity.User;
import org.example.entity.credential.SocialLoginCredential;

@Builder
public record LoginServiceRequest(
    SocialLoginCredential socialLoginCredential
) {

    public User toUser() {
        return User.builder()
            .socialLoginCredential(socialLoginCredential)
            .build();
    }
}
