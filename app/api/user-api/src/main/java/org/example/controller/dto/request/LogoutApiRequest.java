package org.example.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record LogoutApiRequest(

    @Schema(description = "엑세스 토큰")
    @NotNull(message = "액세스 토큰은 필수 입력값입니다.")
    String accessToken,

    @Schema(description = "리프레시 토큰")
    @NotNull(message = "리프레시 토큰은 필수 입력값입니다.")
    String refreshToken
) {

}
