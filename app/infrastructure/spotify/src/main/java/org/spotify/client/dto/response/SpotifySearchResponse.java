package org.spotify.client.dto.response;

import java.util.List;
import org.example.port.dto.param.ArtistSearchPortParam;
import org.example.port.dto.response.ArtistSearchPortResponse;

public record SpotifySearchResponse(
    SpotifyArtistSearchResponse artists
) {

    public ArtistSearchPortResponse toPortResponse() {
        if (artists == null) {
            return ArtistSearchPortResponse.builder()
                .artists(List.of())
                .limit(0)
                .offset(0)
                .hasNext(false)
                .build();
        }

        List<ArtistSearchPortParam> params = artists.items().stream()
            .map(SpotifyArtistItemSearchResponse::toPortParam)
            .toList();

        return ArtistSearchPortResponse.builder()
            .artists(params)
            .limit(artists.limit())
            .offset(artists.offset())
            .hasNext(artists.hasNext())
            .build();
    }
}
