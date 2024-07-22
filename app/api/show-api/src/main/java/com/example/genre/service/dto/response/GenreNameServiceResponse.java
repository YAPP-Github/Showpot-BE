package com.example.genre.service.dto.response;

import java.util.UUID;
import org.example.dto.genre.GenreNameResponse;

public record GenreNameServiceResponse(
    UUID id,
    String name
) {

    public GenreNameServiceResponse(GenreNameResponse genreNameResponse) {
        this(
            genreNameResponse.id(),
            genreNameResponse.name()
        );
    }

}
