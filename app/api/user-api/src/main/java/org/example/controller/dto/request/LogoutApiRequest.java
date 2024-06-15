package org.example.controller.dto.request;

import jakarta.validation.constraints.NotNull;

public record LogoutApiRequest(
    @NotNull(message = "액세스 토큰은 필수 입력값입니다.")
    String accessToken,

    @NotNull(message = "리프레시 토큰은 필수 입력값입니다.")
    String refreshToken
) {

}
