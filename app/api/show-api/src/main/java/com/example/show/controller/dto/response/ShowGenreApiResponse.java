package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.ShowGenreServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowGenreApiResponse(

    @Schema(description = "장르 ID")
    UUID id,

    @Schema(description = "장르 이름")
    String name
) {

    public static ShowGenreApiResponse from(ShowGenreServiceResponse genre) {
        return ShowGenreApiResponse.builder()
            .id(genre.id())
            .name(genre.name())
            .build();
    }
}
