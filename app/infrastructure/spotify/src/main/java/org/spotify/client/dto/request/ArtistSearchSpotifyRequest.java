package org.spotify.client.dto.request;

import lombok.Builder;

/**
 * @param accessToken Spotify API 요청을 위한 토큰
 * @param search 검색어
 * @param limit default: 20, range: 0-50
 * @param offset default: 0, range: 0-1000
 */
@Builder
public record ArtistSearchSpotifyRequest(
    String accessToken,
    String search,
    int limit,
    int offset
) {

    public String toQueryParameter() {
        return String.format(
            "q=%s&type=artist&limit=%d&offset=%d",
            search,
            limit,
            offset
        );
    }
}
