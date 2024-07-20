package org.example.controller.dto.request;

import java.util.UUID;
import org.example.service.dto.request.WithdrawalServiceRequest;

public record WithdrawalApiRequest(
    String accessToken
) {

    public WithdrawalServiceRequest toServiceRequest(UUID userId) {
        return WithdrawalServiceRequest.builder()
            .accessToken(accessToken)
            .userId(userId)
            .build();
    }
}
