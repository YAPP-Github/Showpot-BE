package com.example.genre.service.dto.response;

import java.util.UUID;
import org.example.dto.genre.response.GenreSubscribeResponse;

public record GenreSubscribeServiceResponse(
    UUID id,
    String name
) {

    public GenreSubscribeServiceResponse(GenreSubscribeResponse response) {
        this(
            response.id(),
            response.name()
        );
    }
}
