package com.example.artist.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

public record ArtistPaginationApiResponse(

    @Schema(description = "아티스트 목록")
    List<ArtistSimpleApiResponse> artists,

    @Schema(description = "다음 페이지 존재 여부")
    boolean hasNext
) {

}
