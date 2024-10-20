package org.example.dto.show.request;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.vo.ShowTicketingAtStatus;

@Builder
public record ShowAlertPaginationDomainRequest(
    List<UUID> showIds,
    UUID userId,
    int size,
    ShowTicketingAtStatus type,
    UUID cursorId,
    LocalDateTime cursorValue,
    LocalDateTime now
) {

}
