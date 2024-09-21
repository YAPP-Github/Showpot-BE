package com.example.genre.controller.dto.param;

import com.example.genre.service.dto.param.GenreSubscriptionPaginationServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;

public record GenreSubscriptionPaginationApiParam(
    @Schema(description = "장르 ID")
    UUID id,

    @Schema(description = "장르 이름")
    String name
) {

    public GenreSubscriptionPaginationApiParam(
        GenreSubscriptionPaginationServiceParam response
    ) {
        this(
            response.id(),
            response.name()
        );
    }
}
