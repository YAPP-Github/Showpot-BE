package org.example.dto.show.response;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowAlertDomainResponse(
    UUID id,
    String title,
    LocalDate startDate,
    LocalDate endDate,
    String location,
    String image
) {

}
