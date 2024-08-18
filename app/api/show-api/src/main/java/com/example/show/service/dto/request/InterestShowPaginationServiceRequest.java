package com.example.show.service.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.request.InterestShowPaginationDomainRequest;

@Builder
public record InterestShowPaginationServiceRequest(
    UUID userId,
    int size,
    UUID cursorId,
    LocalDateTime cursorValue
) {

    public InterestShowPaginationDomainRequest toDomainRequest() {
        return InterestShowPaginationDomainRequest.builder()
            .userId(userId)
            .size(size)
            .cursorId(cursorId)
            .cursorValue(cursorValue)
            .build();
    }
}
