package org.spotify.client.dto.request;

import lombok.Builder;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.BodyInserters.FormInserter;

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

    public FormInserter<String> getFormInserter() {
        return BodyInserters.fromFormData("grant_type", grantType)
            .with("client_id", clientId)
            .with("client_secret", clientSecret);
    }
}
