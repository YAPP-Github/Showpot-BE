package org.spotify.client;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;

import lombok.RequiredArgsConstructor;
import org.spotify.client.dto.request.AccessTokenSpotifyRequest;
import org.spotify.client.dto.response.AccessTokenSpotifyResponse;
import org.spotify.property.SpotifyProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters.FormInserter;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class SpotifyClient {

    private final SpotifyProperty spotifyProperty;

    public ResponseEntity<AccessTokenSpotifyResponse> requestToken() {
        FormInserter<String> request = AccessTokenSpotifyRequest.builder()
            .clientId(spotifyProperty.clientId())
            .clientSecret(spotifyProperty.clientSecret())
            .build()
            .getFormInserter();
        ResponseEntity<AccessTokenSpotifyResponse> result = WebClient.builder()
            .baseUrl(spotifyProperty.tokenApiURL())
            .build()
            .post()
            .contentType(APPLICATION_FORM_URLENCODED)
            .body(request)
            .retrieve()
            .toEntity(AccessTokenSpotifyResponse.class)
            .block();

        // TODO: handle error
        return result;
    }
}
