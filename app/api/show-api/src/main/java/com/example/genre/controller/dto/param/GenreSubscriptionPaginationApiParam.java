package com.example.genre.controller.dto.param;

import com.example.genre.service.dto.param.GenreSubscriptionPaginationServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import org.example.dto.response.CursorApiResponse;

public record GenreSubscriptionPaginationApiParam(
    @Schema(description = "조회한 데이터의 Cursor")
    CursorApiResponse cursor,

    @Schema(description = "장르 이름")
    String name
) {

    public GenreSubscriptionPaginationApiParam(
        GenreSubscriptionPaginationServiceParam response
    ) {
        this(
            CursorApiResponse.toCursorId(response.id()),
            response.name()
        );
    }
}
