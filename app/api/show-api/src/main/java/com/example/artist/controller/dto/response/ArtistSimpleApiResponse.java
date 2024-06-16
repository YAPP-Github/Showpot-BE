package com.example.artist.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;

public record ArtistSimpleApiResponse(

    @Schema(description = "아티스트 ID")
    UUID id,

    @Schema(description = "아티스트 이름")
    String name,

    @Schema(description = "아티스트 이미지 주소")
    String image
) {

}
