package com.example.show.service.dto.response;

import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.response.ArtistDomainResponse;

@Builder
public record ShowArtistServiceResponse(
    UUID id,
    String koreanName,
    String englishName,
    String image
) {

    public static ShowArtistServiceResponse from(ArtistDomainResponse artist) {
        return ShowArtistServiceResponse.builder()
            .id(artist.id())
            .koreanName(artist.koreanName())
            .englishName(artist.englishName())
            .image(artist.image())
            .build();
    }
}
