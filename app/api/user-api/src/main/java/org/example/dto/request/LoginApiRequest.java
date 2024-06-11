package org.example.dto.request;

import jakarta.validation.constraints.NotNull;
import org.example.dto.LoginApiDto;
import org.example.entity.credential.SocialCredential;

public record LoginApiRequest(
    @NotNull(message = "소셜 식별자는 필수 입력값입니다.")
    SocialCredential socialCredential
) {

    public LoginApiDto toLoginApiDto() {
        return LoginApiDto.builder()
            .socialCredential(socialCredential)
            .build();
    }
}
