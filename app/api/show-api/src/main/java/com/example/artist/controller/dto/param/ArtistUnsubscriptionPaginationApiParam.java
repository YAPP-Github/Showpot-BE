package com.example.artist.controller.dto.param;

import com.example.artist.service.dto.param.ArtistUnsubscriptionPaginationServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import org.example.dto.response.CursorApiResponse;

public record ArtistUnsubscriptionPaginationApiParam(
    @Schema(description = "조회한 데이터의 Cursor")
    CursorApiResponse cursor,
    @Schema(description = "아티스트 이미지 URL")
    String imageURL,
    @Schema(description = "아티스트 한글 이름")
    String koreanName,
    @Schema(description = "아티스트 영문 이름")
    String englishName
) {

    public static ArtistUnsubscriptionPaginationApiParam from(
        ArtistUnsubscriptionPaginationServiceParam param
    ) {
        return new ArtistUnsubscriptionPaginationApiParam(
            CursorApiResponse.toCursorId(param.artistId()),
            param.artistImageUrl(),
            param.artistKoreanName(),
            param.artistEnglishName()
        );
    }
}
