package org.spotify.client.dto.request;

import lombok.Builder;
import org.springframework.util.LinkedMultiValueMap;

public record AccessTokenSpotifyRequest(
    String grantType,
    String clientId,
    String clientSecret
) {

    public AccessTokenSpotifyRequest(String grantType, String clientId, String clientSecret) {
        this.grantType = grantType;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Builder
    public AccessTokenSpotifyRequest(String clientId, String clientSecret) {
        this(
            "client_credentials",
            clientId,
            clientSecret
        );
    }

    public LinkedMultiValueMap<String, String> toHttpRequestMap() {
        return new LinkedMultiValueMap<>() {
            {
                add("grant_type", grantType);
                add("client_id", clientId);
                add("client_secret", clientSecret);
            }
        };
    }
}
