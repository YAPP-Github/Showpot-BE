package org.spotify.client;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spotify.client.dto.request.AccessTokenSpotifyRequest;
import org.spotify.client.dto.request.ArtistSearchSpotifyRequest;
import org.spotify.client.dto.request.FindArtistsSpotifyRequest;
import org.spotify.client.dto.response.FindSpotifyResponse;
import org.spotify.client.dto.response.SpotifyAccessTokenResponse;
import org.spotify.client.dto.response.SpotifySearchResponse;
import org.spotify.property.SpotifyProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
@Slf4j
public class SpotifyClient {

    private final SpotifyProperty spotifyProperty;

    public String requestAccessToken() {
        ResponseEntity<SpotifyAccessTokenResponse> result = RestClient.builder()
            .baseUrl(spotifyProperty.tokenApiURL())
            .build()
            .post()
            .contentType(APPLICATION_FORM_URLENCODED)
            .body(
                AccessTokenSpotifyRequest.builder()
                    .clientId(spotifyProperty.clientId())
                    .clientSecret(spotifyProperty.clientSecret())
                    .build()
                    .toHttpRequestMap()
            )
            .retrieve()
            .toEntity(SpotifyAccessTokenResponse.class);

        if (result.getBody() == null || !result.getStatusCode().is2xxSuccessful()
        ) {
            log.error("Spotify API request access token failed: {}", result);
            throw new RuntimeException("Spotify API request access token failed");
        }

        return result.getBody().accessToken();
    }

    public SpotifySearchResponse searchArtist(ArtistSearchSpotifyRequest request) {
        ResponseEntity<SpotifySearchResponse> result = RestClient.builder()
            .defaultHeader("Authorization", "Bearer " + request.accessToken())
            .baseUrl(spotifyProperty.apiURL() + "/search?" + request.toQueryParameter())
            .build()
            .get()
            .retrieve()
            .toEntity(SpotifySearchResponse.class);

        if (result.getStatusCode() == HttpStatus.UNAUTHORIZED
            || result.getStatusCode() == HttpStatus.FORBIDDEN
            || result.getStatusCode() == HttpStatus.TOO_MANY_REQUESTS
        ) {
            log.error("Spotify API search artist failed: {}", result);
            throw new RuntimeException("Spotify API request search artist failed");
        }

        return result.getBody();
    }

    public FindSpotifyResponse findArtistsBySpotifyArtistId(FindArtistsSpotifyRequest request) {
        ResponseEntity<FindSpotifyResponse> result = RestClient.builder()
            .defaultHeader("Authorization", "Bearer " + request.accessToken())
            .baseUrl(spotifyProperty.apiURL() + "/artists?" + request.toQueryParameter())
            .build()
            .get()
            .retrieve()
            .toEntity(FindSpotifyResponse.class);

        if (result.getStatusCode() == HttpStatus.UNAUTHORIZED
            || result.getStatusCode() == HttpStatus.FORBIDDEN
            || result.getStatusCode() == HttpStatus.TOO_MANY_REQUESTS
        ) {
            log.error("Spotify API find artists failed: {}", result);
            throw new RuntimeException("Spotify API request find artists failed");
        }

        return result.getBody();
    }
}
