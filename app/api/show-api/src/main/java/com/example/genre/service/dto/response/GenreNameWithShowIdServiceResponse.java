package com.example.genre.service.dto.response;

import java.util.List;
import java.util.UUID;
import org.example.dto.genre.response.GenreNamesWithShowIdDomainResponse;

public record GenreNameWithShowIdServiceResponse(
    UUID showId,
    List<GenreNameServiceResponse> genreNames
) {

    public GenreNameWithShowIdServiceResponse(
        GenreNamesWithShowIdDomainResponse response
    ) {
        this(
            response.showId(),
            response.genreNames().stream()
                .map(GenreNameServiceResponse::new)
                .toList()
        );
    }

}
