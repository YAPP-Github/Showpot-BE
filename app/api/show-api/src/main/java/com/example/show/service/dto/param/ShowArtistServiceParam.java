package com.example.show.service.dto.param;

import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.response.ArtistDomainResponse;

@Builder
public record ShowArtistServiceParam(
    UUID id,
    String name,
    String image
) {

    public static ShowArtistServiceParam from(ArtistDomainResponse artist) {
        return ShowArtistServiceParam.builder()
            .id(artist.id())
            .name(artist.name())
            .image(artist.image())
            .build();
    }
}
