package com.example.artist.service.dto.param;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.response.ArtistSearchSimpleDomainResponse;

@Builder
public record ArtistSearchPaginationServiceParam(
    UUID artistId,
    String artistImageUrl,
    String name,
    String artistSpotifyId,
    boolean isSubscribed
) {

    public static ArtistSearchPaginationServiceParam from(
        ArtistSearchSimpleDomainResponse response,
        List<UUID> artistSubscriptions
    ) {
        boolean isSubscribed = response.id() != null && artistSubscriptions.contains(response.id());

        return ArtistSearchPaginationServiceParam.builder()
            .artistId(response.id())
            .artistImageUrl(response.image())
            .name(response.name())
            .artistSpotifyId(response.spotifyId())
            .isSubscribed(isSubscribed)
            .build();
    }
}
