package org.example.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record TicketingAlertsDomainResponse(

    String userFcmToken,
    String name,
    LocalDateTime reservedAt,
    UUID showId
) {

}
