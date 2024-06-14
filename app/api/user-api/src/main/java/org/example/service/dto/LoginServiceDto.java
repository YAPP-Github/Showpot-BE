package org.example.service.dto;

import lombok.Builder;
import org.example.entity.User;
import org.example.entity.credential.SocialCredentials;

@Builder
public record LoginServiceDto(
    SocialCredentials socialCredentials

) {

    public User toUser() {
        return User.builder()
            .socialCredentials(socialCredentials)
            .build();
    }
}
