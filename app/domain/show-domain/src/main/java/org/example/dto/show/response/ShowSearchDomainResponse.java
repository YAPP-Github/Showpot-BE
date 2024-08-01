package org.example.dto.show.response;

import java.time.LocalDate;
import java.util.UUID;

public record ShowSearchDomainResponse(
    UUID id,
    String title,
    LocalDate startDate,
    LocalDate endDate,
    String location,
    String image
) {

}
