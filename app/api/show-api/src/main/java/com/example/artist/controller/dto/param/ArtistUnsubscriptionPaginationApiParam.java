package com.example.artist.controller.dto.param;

import com.example.artist.service.dto.param.ArtistUnsubscriptionPaginationServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;

public record ArtistUnsubscriptionPaginationApiParam(
    @Schema(description = "아티스트 ID")
    UUID id,
    @Schema(description = "아티스트 이미지 URL")
    String imageURL,
    @Schema(description = "아티스트 이름")
    String name
) {

    public static ArtistUnsubscriptionPaginationApiParam from(
        ArtistUnsubscriptionPaginationServiceParam param
    ) {
        return new ArtistUnsubscriptionPaginationApiParam(
            param.id(),
            param.image(),
            param.name()
        );
    }
}
