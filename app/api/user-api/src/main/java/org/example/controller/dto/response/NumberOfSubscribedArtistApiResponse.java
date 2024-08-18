package org.example.controller.dto.response;

import org.example.service.dto.response.NumberOfSubscribedArtistServiceResponse;

public record NumberOfSubscribedArtistApiResponse(
    long count
) {

    public static NumberOfSubscribedArtistApiResponse from(NumberOfSubscribedArtistServiceResponse response) {
        return new NumberOfSubscribedArtistApiResponse(response.count());
    }
}
