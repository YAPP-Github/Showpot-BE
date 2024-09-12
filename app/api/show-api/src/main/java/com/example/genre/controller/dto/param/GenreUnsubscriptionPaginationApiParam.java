package com.example.genre.controller.dto.param;

import com.example.genre.service.dto.param.GenreUnsubscriptionPaginationServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import org.example.dto.response.CursorApiResponse;

public record GenreUnsubscriptionPaginationApiParam(
    @Schema(description = "장르 Cursor")
    CursorApiResponse cursor,
    @Schema(description = "장르 이름")
    String name
) {

    public GenreUnsubscriptionPaginationApiParam(
        GenreUnsubscriptionPaginationServiceParam response
    ) {
        this(
            CursorApiResponse.toCursorId(response.id()),
            response.name()
        );
    }
}
