package com.example.show.controller.dto.param;

import com.example.show.service.dto.param.ShowArtistServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowArtistApiParam(

    @Schema(description = "아티스트 ID")
    UUID id,

    @Schema(description = "아티스트 이름")
    String name,

    @Schema(description = "아티스트 이미지 URL")
    String imageURL
) {

    public static ShowArtistApiParam from(ShowArtistServiceParam artists) {
        return ShowArtistApiParam.builder()
            .id(artists.id())
            .name(artists.name())
            .imageURL(artists.image())
            .build();
    }
}
