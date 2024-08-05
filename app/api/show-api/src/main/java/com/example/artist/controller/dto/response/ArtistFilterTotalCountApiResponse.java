package com.example.artist.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record ArtistFilterTotalCountApiResponse(
    @Schema(description = "필터링한 아티스트 총 개수")
    int totalCount
) {

    public static ArtistFilterTotalCountApiResponse from(int totalCount) {
        return new ArtistFilterTotalCountApiResponse(totalCount);
    }

}
