package org.example.dto;

import lombok.Builder;
import org.example.entity.User;
import org.example.entity.credential.SocialCredential;

@Builder
public record LoginApiDto(
    SocialCredential socialCredential
) {

    public User toUser() {
        return User.builder()
            .socialCredential(socialCredential)
            .build();
    }
}
