package com.example.artist.controller.dto.response;

import com.example.artist.service.dto.response.ArtistSearchServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;

public record ArtistSearchApiResponse(
    @Schema(description = "아티스트 ID")
    UUID id,

    @Schema(description = "아티스트 한국 이름")
    String koreanName,

    @Schema(description = "아티스트 영어 이름")
    String englishName,

    @Schema(description = "아티스트 이미지")
    String image
) {

    public ArtistSearchApiResponse(ArtistSearchServiceResponse artistSearchServiceResponse) {
        this(
            artistSearchServiceResponse.id(),
            artistSearchServiceResponse.koreanName(),
            artistSearchServiceResponse.englishName(),
            artistSearchServiceResponse.image()
        );
    }
}
