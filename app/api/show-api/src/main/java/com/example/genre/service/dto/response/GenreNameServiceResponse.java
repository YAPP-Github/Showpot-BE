package com.example.genre.service.dto.response;

import java.util.UUID;
import org.example.dto.genre.response.GenreNameDomainResponse;

public record GenreNameServiceResponse(
    UUID id,
    String name
) {

    public GenreNameServiceResponse(GenreNameDomainResponse genreNameResponse) {
        this(
            genreNameResponse.id(),
            genreNameResponse.name()
        );
    }

}
