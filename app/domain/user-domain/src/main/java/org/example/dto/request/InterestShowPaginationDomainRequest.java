package org.example.dto.request;

import java.util.UUID;
import lombok.Builder;

@Builder
public record InterestShowPaginationDomainRequest(
    UUID userId,
    int size,
    UUID cursorId
) {

}
