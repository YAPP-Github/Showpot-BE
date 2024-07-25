package com.example.artist.controller.dto.response;

import com.example.artist.service.dto.response.ArtistSubscriptionServiceResponse;
import java.util.List;
import java.util.UUID;

public record ArtistSubscriptionApiResponse(
    List<UUID> successSubscriptionArtistIds
) {

    public static ArtistSubscriptionApiResponse from(ArtistSubscriptionServiceResponse response) {
        return new ArtistSubscriptionApiResponse(response.successSubscriptionArtistIds());
    }
}
