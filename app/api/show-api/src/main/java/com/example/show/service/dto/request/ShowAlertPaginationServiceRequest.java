package com.example.show.service.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.show.request.ShowAlertPaginationDomainRequest;

@Builder
public record ShowAlertPaginationServiceRequest(
    UUID userId,
    int size,
    UUID cursorId,
    LocalDateTime cursorValue
) {

    public ShowAlertPaginationDomainRequest toDomainRequest(List<UUID> showIds) {
        return ShowAlertPaginationDomainRequest.builder()
            .showIds(showIds)
            .userId(userId)
            .size(size)
            .cursorId(cursorId)
            .cursorValue(cursorValue)
            .build();
    }
}
