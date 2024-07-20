package com.example.genre.controller.dto.response;

import com.example.genre.service.dto.response.GenreNameServiceResponse;
import java.util.UUID;

public record GenreNameApiFormResponse(
    UUID id,
    String name
) {

    public GenreNameApiFormResponse(GenreNameServiceResponse genreNameServiceResponse) {
        this (
            genreNameServiceResponse.id(),
            genreNameServiceResponse.name()
        );
    }

}
