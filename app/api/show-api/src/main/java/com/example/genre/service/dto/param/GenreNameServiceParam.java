package com.example.genre.service.dto.param;

import java.util.UUID;
import org.example.dto.genre.response.GenreNameDomainResponse;

public record GenreNameServiceParam(
    UUID id,
    String name
) {

    public GenreNameServiceParam(GenreNameDomainResponse genreNameResponse) {
        this(
            genreNameResponse.id(),
            genreNameResponse.name()
        );
    }

}
