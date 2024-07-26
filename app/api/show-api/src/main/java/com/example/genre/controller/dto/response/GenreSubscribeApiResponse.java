package com.example.genre.controller.dto.response;

import com.example.genre.service.dto.response.GenreSubscribeServiceResponse;
import java.util.UUID;

public record GenreSubscribeApiResponse(
    UUID id,
    String name
) {

    public GenreSubscribeApiResponse(GenreSubscribeServiceResponse response) {
        this(
            response.id(),
            response.name()
        );
    }
}
