package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.ShowArtistServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowArtistApiResponse(

    @Schema(description = "아티스트 ID")
    UUID id,

    @Schema(description = "아티스트 이름")
    String name,

    @Schema(description = "아티스트 이미지 URL")
    String imageURL
) {

    public static ShowArtistApiResponse from(ShowArtistServiceResponse artists) {
        return ShowArtistApiResponse.builder()
            .id(artists.id())
            .name(artists.name())
            .imageURL(artists.image())
            .build();
    }
}
