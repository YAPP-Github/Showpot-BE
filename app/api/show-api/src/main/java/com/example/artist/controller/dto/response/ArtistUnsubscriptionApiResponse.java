package com.example.artist.controller.dto.response;

import com.example.artist.service.dto.response.ArtistUnsubscriptionServiceResponse;
import java.util.List;
import java.util.UUID;

public record ArtistUnsubscriptionApiResponse(
    List<UUID> successUnsubscriptionArtistIds
) {

    public static ArtistUnsubscriptionApiResponse from(
        ArtistUnsubscriptionServiceResponse response
    ) {
        return new ArtistUnsubscriptionApiResponse(response.successUnsubscriptionArtistIds());
    }
}
