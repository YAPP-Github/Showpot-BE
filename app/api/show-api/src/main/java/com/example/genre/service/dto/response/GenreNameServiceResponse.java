package com.example.genre.service.dto.response;

import java.util.UUID;

public record GenreNameServiceResponse(
    UUID id,
    String name
) {

}
