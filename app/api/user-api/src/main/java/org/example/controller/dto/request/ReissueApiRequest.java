package org.example.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.example.service.dto.request.ReissueServiceRequest;

public record ReissueApiRequest(
    @Schema(description = "재발급 토큰")
    @NotNull(message = "refreshToken은 필수 입력값입니다.")
    String refreshToken
) {

    public ReissueServiceRequest toServiceRequest() {
        return new ReissueServiceRequest(refreshToken);
    }
}
