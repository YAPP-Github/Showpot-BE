package org.spotify.adapter;

import lombok.RequiredArgsConstructor;
import org.example.port.ArtistSearchPort;
import org.example.port.dto.request.ArtistSearchPortRequest;
import org.example.port.dto.request.ArtistsDetailPortRequest;
import org.example.port.dto.response.ArtistSearchPortResponse;
import org.example.port.dto.response.ArtistsDetailPortResponse;
import org.example.vo.ArtistSearchAdapterType;
import org.spotify.client.SpotifyClient;
import org.spotify.client.dto.request.ArtistSearchSpotifyRequest;
import org.spotify.client.dto.request.ArtistsSpotifyRequest;
import org.spotify.client.dto.response.SpotifyArtistsResponse;
import org.spotify.client.dto.response.SpotifySearchResponse;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArtistSearchAdapter implements ArtistSearchPort {

    private final SpotifyClient spotifyClient;

    @Override
    public ArtistSearchAdapterType getAdapterType() {
        return ArtistSearchAdapterType.SPOTIFY;
    }

    @Override
    public String getAccessToken() {
        return spotifyClient.requestAccessToken();
    }

    @Override
    public ArtistSearchPortResponse searchArtist(ArtistSearchPortRequest request) {
        SpotifySearchResponse response = spotifyClient.searchArtist(
            ArtistSearchSpotifyRequest.builder()
                .accessToken(request.accessToken())
                .search(request.search())
                .limit(request.limit())
                .offset(request.offset())
                .build()
        );

        return response.toPortResponse();
    }

    @Override
    public ArtistsDetailPortResponse findArtistsBySpotifyArtistId(
        ArtistsDetailPortRequest request
    ) {
        SpotifyArtistsResponse response = spotifyClient.findArtistsBySpotifyArtistId(
            ArtistsSpotifyRequest.builder()
                .accessToken(request.accessToken())
                .spotifyArtistIds(request.spotifyArtistIds())
                .build()
        );

        return response.toPortResponse();
    }
}
