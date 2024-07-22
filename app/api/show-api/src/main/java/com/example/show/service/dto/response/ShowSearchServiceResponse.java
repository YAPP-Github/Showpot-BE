package com.example.show.service.dto.response;

import java.time.LocalDate;
import java.util.UUID;
import org.example.dto.show.ShowSearchResponse;

public record ShowSearchServiceResponse(
    UUID id,
    String title,
    LocalDate date,
    String location,
    String image
) {

    public ShowSearchServiceResponse(ShowSearchResponse showSearchResponse) {
        this(
            showSearchResponse.id(),
            showSearchResponse.title(),
            showSearchResponse.date(),
            showSearchResponse.location(),
            showSearchResponse.image()
        );
    }
}
