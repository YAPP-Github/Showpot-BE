package org.example.dto.show.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record ShowTicketingDomainResponse(
    UUID id,
    String title,
    LocalDate endDate,
    LocalDateTime ticketingAt,
    String location,
    String image
) {

}
