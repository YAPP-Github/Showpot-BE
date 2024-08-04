package com.example.show.service.dto.param;

import java.time.LocalDate;
import java.util.UUID;
import org.example.dto.show.response.ShowSearchDomainResponse;

public record ShowSearchPaginationServiceParam(
    UUID id,
    String title,
    LocalDate date,
    String location,
    String image
) {

    public ShowSearchPaginationServiceParam(ShowSearchDomainResponse showSearchDomainResponse) {
        this(
            showSearchDomainResponse.id(),
            showSearchDomainResponse.title(),
            showSearchDomainResponse.startDate(),
            showSearchDomainResponse.location(),
            showSearchDomainResponse.image()
        );
    }
}
