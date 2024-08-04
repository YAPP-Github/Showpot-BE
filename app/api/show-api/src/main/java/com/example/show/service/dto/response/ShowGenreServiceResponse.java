package com.example.show.service.dto.response;

import java.util.UUID;
import lombok.Builder;
import org.example.dto.genre.response.GenreDomainResponse;

@Builder
public record ShowGenreServiceResponse(
    UUID id,
    String name
) {

    public static ShowGenreServiceResponse from(GenreDomainResponse genre) {
        return ShowGenreServiceResponse.builder()
            .id(genre.id())
            .name(genre.name())
            .build();
    }
}
