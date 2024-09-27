package com.example.genre.controller.dto.response;

import com.example.genre.service.dto.param.GenreNameServiceParam;
import java.util.UUID;

public record GenreNameApiResponse(
    UUID id,
    String name
) {

    public GenreNameApiResponse(GenreNameServiceParam genreNameServiceResponse) {
        this (
            genreNameServiceResponse.id(),
            genreNameServiceResponse.name()
        );
    }

}
