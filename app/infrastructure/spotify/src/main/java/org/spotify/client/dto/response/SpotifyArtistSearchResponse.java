package org.spotify.client.dto.response;

import java.util.List;

public record SpotifyArtistSearchResponse(
    String href,
    int limit,
    String next,
    int offset,
    String previous,
    int total,
    List<SpotifyArtistItemSearchResponse> items
) {

}
