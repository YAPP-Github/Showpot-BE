package com.example.genre.controller.dto.param;

import com.example.genre.service.dto.param.GenrePaginationServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;

public record GenrePaginationApiParam(

    @Schema(description = "장르 ID")
    UUID id,

    @Schema(description = "장르 이름")
    String name,

    @Schema(description = "장르 구독 여부")
    boolean isSubscribed
) {

    public GenrePaginationApiParam(GenrePaginationServiceParam param) {
        this(
            param.id(),
            param.name(),
            param.isSubscribed()
        );
    }
}
