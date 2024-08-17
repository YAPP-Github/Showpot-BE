package org.example.dto.show.response;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowSearchDomainResponse(
    UUID id,
    String title,
    LocalDate startDateAt,
    LocalDate endDateAt,
    String location,
    String image
) {

}
