package com.example.show.controller.dto.param;

import com.example.show.service.dto.param.ShowGenreServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowGenreApiParam(

    @Schema(description = "장르 ID")
    UUID id,

    @Schema(description = "장르 이름")
    String name
) {

    public static ShowGenreApiParam from(ShowGenreServiceParam genre) {
        return ShowGenreApiParam.builder()
            .id(genre.id())
            .name(genre.name())
            .build();
    }
}
