package com.example.artist.controller.dto.response;


import com.example.artist.service.dto.response.NumberOfSubscribedArtistServiceResponse;

public record NumberOfSubscribedArtistApiResponse(
    long count
) {

    public static NumberOfSubscribedArtistApiResponse from(
        NumberOfSubscribedArtistServiceResponse response
    ) {
        return new NumberOfSubscribedArtistApiResponse(response.count());
    }
}
