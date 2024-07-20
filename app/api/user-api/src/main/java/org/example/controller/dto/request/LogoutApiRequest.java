package org.example.controller.dto.request;

import java.util.UUID;
import org.example.service.dto.request.LogoutServiceRequest;

public record LogoutApiRequest(
    String accessToken
) {

    public LogoutServiceRequest toServiceRequest(UUID userId) {
        return LogoutServiceRequest.builder()
            .accessToken(accessToken)
            .userId(userId)
            .build();
    }
}
