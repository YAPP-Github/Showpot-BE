package org.example.controller.dto;

import lombok.Builder;
import org.example.entity.credential.SocialCredentials;
import org.example.service.dto.request.LoginServiceRequest;

@Builder
public record LoginApiDto(
    SocialCredentials socialCredentials
) {

    public LoginServiceRequest toLoginServiceRequest() {
        return LoginServiceRequest.builder()
            .socialCredentials(socialCredentials)
            .build();
    }
}
