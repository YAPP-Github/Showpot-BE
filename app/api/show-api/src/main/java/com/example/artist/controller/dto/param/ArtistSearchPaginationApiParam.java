package com.example.artist.controller.dto.param;

import com.example.artist.service.dto.param.ArtistSearchPaginationServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;

public record ArtistSearchPaginationApiParam(
    @Schema(description = "아티스트 ID")
    UUID id,
    @Schema(description = "아티스트 이미지 URL")
    String imageURL,
    @Schema(description = "아티스트 한글 이름")
    String koreanName,
    @Schema(description = "아티스트 영문 이름")
    String englishName
) {

    public static ArtistSearchPaginationApiParam from(ArtistSearchPaginationServiceParam param) {
        return new ArtistSearchPaginationApiParam(
            param.artistId(),
            param.artistImageUrl(),
            param.artistKoreanName(),
            param.artistEnglishName()
        );
    }
}
