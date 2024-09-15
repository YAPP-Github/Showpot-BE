package com.example.genre.service.dto.response;

public record NumberOfSubscribedGenreServiceResponse(
    long count
) {

    public static NumberOfSubscribedGenreServiceResponse from(long count) {
        return new NumberOfSubscribedGenreServiceResponse(count);
    }
}
