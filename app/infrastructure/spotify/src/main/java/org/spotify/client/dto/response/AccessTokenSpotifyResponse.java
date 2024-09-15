package org.spotify.client.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AccessTokenSpotifyResponse(
    @JsonProperty("access_token")
    String accessToken,
    @JsonProperty("token_type")
    String tokenType,
    @JsonProperty("expires_in")
    int expiresIn
) {

}
