package org.example.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginApiResponse(

    @Schema(description = "액세스 토큰")
    String accessToken,

    @Schema(description = "리프레시 토큰")
    String refreshToken
) {
}
