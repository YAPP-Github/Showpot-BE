package org.spotify.client.dto.request;

import java.util.List;
import lombok.Builder;

/**
 * @param accessToken Spotify API 요청을 위한 토큰
 * @param spotifyArtistIds Spotify Artist Id들
 */
@Builder
public record FindArtistsSpotifyRequest(
    String accessToken,
    List<String> spotifyArtistIds
) {

    public String toQueryParameter() {
        return String.format(
            "ids=%s",
            String.join(",", spotifyArtistIds)
        );
    }
}
