package org.spotify.client.dto.response;

import java.util.List;
import org.example.port.dto.param.ArtistSearchPortParam;

public record FindSpotifyResponse(
    List<SpotifyArtistItemSearchResponse> artists
) {

    public List<ArtistSearchPortParam> toPortResponse() {
        if (artists == null) {
            return List.of();
        }

        return artists.stream()
            .map(SpotifyArtistItemSearchResponse::toPortParam)
            .toList();
    }
}
