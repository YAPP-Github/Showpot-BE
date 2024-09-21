package com.example.artist.controller.dto.param;

import com.example.artist.service.dto.param.ArtistSearchPaginationServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ArtistSearchPaginationApiParam(
    @Schema(description = "아티스트 ID")
    UUID id,

    @Schema(description = "아티스트 이미지 URL")
    String imageURL,

    @Schema(description = "아티스트 이름")
    String name,

    @Schema(description = "아티스트의 스포티파이 ID")
    String artistSpotifyId,

    @Schema(description = "아티스트 구독 여부")
    boolean isSubscribed
) {

    public static ArtistSearchPaginationApiParam from(ArtistSearchPaginationServiceParam param) {
        return ArtistSearchPaginationApiParam.builder()
            .id(param.artistId())
            .name(param.name())
            .imageURL(param.artistImageUrl())
            .artistSpotifyId(param.artistSpotifyId())
            .isSubscribed(param.isSubscribed())
            .build();
    }
}
