package com.example.genre.controller.dto.response;

import com.example.genre.service.dto.response.GenreNameServiceResponse;
import java.util.UUID;

public record GenreNameApiResponse(
    UUID id,
    String name
) {

    public GenreNameApiResponse(GenreNameServiceResponse genreNameServiceResponse) {
        this (
            genreNameServiceResponse.id(),
            genreNameServiceResponse.name()
        );
    }

}
