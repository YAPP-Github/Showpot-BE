package com.example.show.service.dto.response;

import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.response.ArtistDomainResponse;

@Builder
public record ShowArtistSimpleServiceResponse(
    UUID id,
    String koreanName,
    String englishName,
    String image
) {

    public static ShowArtistSimpleServiceResponse from(ArtistDomainResponse response) {
        return ShowArtistSimpleServiceResponse.builder()
            .id(response.id())
            .koreanName(response.koreanName())
            .englishName(response.englishName())
            .image(response.image())
            .build();
    }
}
