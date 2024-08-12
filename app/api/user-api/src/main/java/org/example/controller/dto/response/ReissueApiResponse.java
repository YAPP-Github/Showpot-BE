package org.example.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record ReissueApiResponse(

    @Schema(description = "재발급된 액세스 토큰")
    String accessToken,

    @Schema(description = "재발급된 리프레시 토큰")
    String refreshToken
) {

}
