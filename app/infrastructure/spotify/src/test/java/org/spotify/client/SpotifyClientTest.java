package org.spotify.client;

import org.junit.jupiter.api.Test;
import org.spotify.client.dto.request.ArtistSearchSpotifyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@ActiveProfiles("spotify-local")
class SpotifyClientTest {

    @Autowired
    private SpotifyClient spotifyClient;

    @Test
    void requestToken() {
        var result = spotifyClient.requestToken();
        System.out.println(result.getBody().accessToken());
    }

    @Test
    void searchArtist() {
        String accessToken = spotifyClient.requestToken().getBody().accessToken();
        var result = spotifyClient.searchArtist(
            ArtistSearchSpotifyRequest.builder()
                .accessToken(accessToken)
                .search("BTS")
                .limit(10)
                .offset(0)
                .build()
        );
        System.out.println(result);
    }
}