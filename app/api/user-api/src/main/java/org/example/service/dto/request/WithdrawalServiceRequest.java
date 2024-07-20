package org.example.service.dto.request;

import java.util.UUID;
import lombok.Builder;

@Builder
public record WithdrawalServiceRequest(
    String accessToken,
    UUID userId
) {

}
