package com.example.artist.controller.dto.param;

import com.example.artist.service.dto.param.ArtistSearchPaginationServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import org.example.dto.response.CursorApiResponse;

public record ArtistSearchPaginationApiParam(
    @Schema(description = "조회한 데이터의 Cursor")
    CursorApiResponse cursor,

    @Schema(description = "아티스트 이미지 URL")
    String imageURL,

    @Schema(description = "아티스트 한글 이름")
    String koreanName,

    @Schema(description = "아티스트 영문 이름")
    String englishName,

    @Schema(description = "아티스트 구독 여부")
    boolean isSubscribed
) {

    public static ArtistSearchPaginationApiParam from(ArtistSearchPaginationServiceParam param) {
        return new ArtistSearchPaginationApiParam(
            CursorApiResponse.toCursorId(param.artistId()),
            param.artistImageUrl(),
            param.artistKoreanName(),
            param.artistEnglishName(),
            param.isSubscribed()
        );
    }
}
