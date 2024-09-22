package com.example.artist.service.dto.request;

import java.util.List;
import java.util.UUID;

public record ArtistSubscriptionServiceRequest(
    List<String> spotifyArtistIds,
    UUID userId
) {

}
