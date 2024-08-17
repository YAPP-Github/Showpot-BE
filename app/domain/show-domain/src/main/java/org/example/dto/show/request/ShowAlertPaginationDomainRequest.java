package org.example.dto.show.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowAlertPaginationDomainRequest(
    List<UUID> showIds,
    UUID userId,
    int size,
    UUID cursorId
) {

}
