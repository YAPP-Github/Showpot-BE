package org.example.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;

@Builder
public record InterestShowPaginationDomainRequest(
    UUID userId,
    int size,
    UUID cursorId,
    LocalDateTime cursorInterestedAt
) {

}
