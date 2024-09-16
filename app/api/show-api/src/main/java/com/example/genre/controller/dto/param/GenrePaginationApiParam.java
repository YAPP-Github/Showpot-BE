package com.example.genre.controller.dto.param;

import com.example.genre.service.dto.param.GenrePaginationServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import org.example.dto.response.CursorApiResponse;

public record GenrePaginationApiParam(

    @Schema(description = "조회한 데이터의 Cursor")
    CursorApiResponse cursor,

    @Schema(description = "장르 이름")
    String name,

    @Schema(description = "장르 구독 여부")
    boolean isSubscribed
) {

    public GenrePaginationApiParam(GenrePaginationServiceParam param) {
        this(
            CursorApiResponse.toCursorId(param.id()),
            param.name(),
            param.isSubscribed()
        );
    }
}
