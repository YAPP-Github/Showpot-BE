package org.spotify.client.dto.response;

public record SpotifyArtistImageSearchResponse(
    int height,
    int width,
    String url
) {

}
