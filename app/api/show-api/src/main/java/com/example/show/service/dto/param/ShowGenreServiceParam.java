package com.example.show.service.dto.param;

import java.util.UUID;
import lombok.Builder;
import org.example.dto.genre.response.GenreDomainResponse;

@Builder
public record ShowGenreServiceParam(
    UUID id,
    String name
) {

    public static ShowGenreServiceParam from(GenreDomainResponse genre) {
        return ShowGenreServiceParam.builder()
            .id(genre.id())
            .name(genre.name())
            .build();
    }
}
