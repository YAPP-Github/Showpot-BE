package org.example.dto.show.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowAlertDomainResponse(
    UUID id,
    String title,
    LocalDate startDateAt,
    LocalDate endDateAt,
    String location,
    String image,
    LocalDateTime ticketingAt
) {

}
