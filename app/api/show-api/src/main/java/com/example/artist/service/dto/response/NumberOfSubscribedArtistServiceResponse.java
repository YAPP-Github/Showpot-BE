package com.example.artist.service.dto.response;

public record NumberOfSubscribedArtistServiceResponse(
    long count
) {

    public static NumberOfSubscribedArtistServiceResponse from(long count) {
        return new NumberOfSubscribedArtistServiceResponse(count);
    }
}
