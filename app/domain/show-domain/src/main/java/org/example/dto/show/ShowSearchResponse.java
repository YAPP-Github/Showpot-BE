package org.example.dto.show;

import java.time.LocalDate;
import java.util.UUID;

public record ShowSearchResponse(
    UUID id,
    String title,
    LocalDate date,
    String location,
    String image
) {

}
