package com.example.show.service.dto.response;

import java.time.LocalDate;
import java.util.UUID;
import org.example.dto.show.ShowSearchDomainResponse;

public record ShowSearchServiceResponse(
    UUID id,
    String title,
    LocalDate date,
    String location,
    String image
) {

    public ShowSearchServiceResponse() {
        this(
            null,
            "",
            null,
            "",
            ""
        );
    }

    public ShowSearchServiceResponse(ShowSearchDomainResponse showSearchDomainResponse) {
        this(
            showSearchDomainResponse.id(),
            showSearchDomainResponse.title(),
            showSearchDomainResponse.date(),
            showSearchDomainResponse.location(),
            showSearchDomainResponse.image()
        );
    }
}
