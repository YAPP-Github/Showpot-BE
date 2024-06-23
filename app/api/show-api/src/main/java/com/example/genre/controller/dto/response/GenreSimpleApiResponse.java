package com.example.genre.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;

public record GenreSimpleApiResponse(

    @Schema(description = "장르 ID")
    UUID id,

    @Schema(description = "장르 이름")
    String name,

    @Schema(description = "장르 이미지 주소")
    String image
) {

}
