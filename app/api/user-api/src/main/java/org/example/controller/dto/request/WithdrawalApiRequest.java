package org.example.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import org.example.service.dto.request.WithdrawalServiceRequest;

public record WithdrawalApiRequest(
    @NotNull(message = "accessToken은 필수 입력값입니다.")
    String accessToken
) {

    public WithdrawalServiceRequest toServiceRequest(UUID userId) {
        return WithdrawalServiceRequest.builder()
            .accessToken(accessToken)
            .userId(userId)
            .build();
    }
}
