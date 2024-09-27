package org.spotify.client.dto.response;

import java.util.List;
import org.example.port.dto.response.ArtistsDetailPortResponse;

public record SpotifyArtistsResponse(
    List<SpotifyArtistItemSearchResponse> artists
) {

    public ArtistsDetailPortResponse toPortResponse() {
        if (artists == null) {
            return new ArtistsDetailPortResponse(List.of());
        }

        return new ArtistsDetailPortResponse(
            artists.stream()
                .map(SpotifyArtistItemSearchResponse::toPortParam)
                .toList()
        );
    }
}
