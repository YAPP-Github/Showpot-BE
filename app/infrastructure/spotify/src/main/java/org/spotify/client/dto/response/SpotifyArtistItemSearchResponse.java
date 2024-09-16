package org.spotify.client.dto.response;

import java.util.List;

public record SpotifyArtistItemSearchResponse(
    String id,
    String name,
    List<String> genres,
    List<SpotifyArtistImageSearchResponse> images
) {

}
