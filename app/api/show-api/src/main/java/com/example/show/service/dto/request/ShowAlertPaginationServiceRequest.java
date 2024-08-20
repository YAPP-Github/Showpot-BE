package com.example.show.service.dto.request;

import com.example.show.vo.ShowTicketingAtStatusApiType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.show.request.ShowAlertPaginationDomainRequest;

@Builder
public record ShowAlertPaginationServiceRequest(
    UUID userId,
    int size,
    ShowTicketingAtStatusApiType type,
    UUID cursorId,
    LocalDateTime cursorValue
) {

    public ShowAlertPaginationDomainRequest toDomainRequest(
        List<UUID> showIds,
        LocalDateTime now
    ) {
        return ShowAlertPaginationDomainRequest.builder()
            .showIds(showIds)
            .userId(userId)
            .size(size)
            .type(type.toDomainType())
            .cursorId(cursorId)
            .cursorValue(cursorValue)
            .now(now)
            .build();
    }
}
