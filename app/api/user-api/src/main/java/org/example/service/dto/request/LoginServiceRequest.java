package org.example.service.dto.request;

import lombok.Builder;
import org.example.entity.credential.SocialCredentials;
import org.example.service.dto.LoginServiceDto;

@Builder
public record LoginServiceRequest(
    SocialCredentials socialCredentials
) {

    public LoginServiceDto toLoginServiceDto() {
        return LoginServiceDto.builder()
            .socialCredentials(socialCredentials)
            .build();
    }
}
