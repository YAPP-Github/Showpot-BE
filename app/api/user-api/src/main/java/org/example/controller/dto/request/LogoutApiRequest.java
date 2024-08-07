package org.example.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import org.example.service.dto.request.LogoutServiceRequest;

public record LogoutApiRequest(
    @NotNull(message = "accessToken은 필수 입력값입니다.")
    String accessToken
) {

    public LogoutServiceRequest toServiceRequest(UUID userId) {
        return LogoutServiceRequest.builder()
            .accessToken(accessToken)
            .userId(userId)
            .build();
    }
}
