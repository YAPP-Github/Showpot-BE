package org.example.dto.show.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record ShowTicketingDomainResponse(
    UUID id,
    String title,
    LocalDateTime ticketingAt,
    String location,
    String image
) {

}
