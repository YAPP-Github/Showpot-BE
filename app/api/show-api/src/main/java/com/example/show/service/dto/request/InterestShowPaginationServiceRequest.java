package com.example.show.service.dto.request;

import java.util.UUID;
import lombok.Builder;
import org.example.dto.request.InterestShowPaginationDomainRequest;

@Builder
public record InterestShowPaginationServiceRequest(
    UUID userId,
    int size,
    UUID cursorId
) {

    public InterestShowPaginationDomainRequest toDomainRequest() {
        return InterestShowPaginationDomainRequest.builder()
            .userId(userId)
            .size(size)
            .cursorId(cursorId)
            .build();
    }
}
