package com.example.show.service.dto.response;

import java.util.UUID;
import lombok.Builder;
import org.example.dto.genre.response.GenreDomainResponse;

@Builder
public record ShowGenreSimpleServiceResponse(
    UUID id,
    String name
) {

    public static ShowGenreSimpleServiceResponse from(GenreDomainResponse genre) {
        return ShowGenreSimpleServiceResponse.builder()
            .id(genre.id())
            .name(genre.name())
            .build();
    }
}
