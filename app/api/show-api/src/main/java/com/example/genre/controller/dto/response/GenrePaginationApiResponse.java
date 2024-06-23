package com.example.genre.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

public record GenrePaginationApiResponse(

    @Schema(description = "장르 목록")
    List<GenreSimpleApiResponse> genres,

    @Schema(description = "다음 페이지 존재 여부")
    boolean hasNext
) {

}
