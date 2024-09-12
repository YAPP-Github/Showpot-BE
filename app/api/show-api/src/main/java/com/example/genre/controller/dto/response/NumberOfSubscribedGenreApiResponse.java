package com.example.genre.controller.dto.response;


import com.example.genre.service.dto.response.NumberOfSubscribedGenreServiceResponse;

public record NumberOfSubscribedGenreApiResponse(
    long count
) {

    public static NumberOfSubscribedGenreApiResponse from(
        NumberOfSubscribedGenreServiceResponse response
    ) {
        return new NumberOfSubscribedGenreApiResponse(response.count());
    }
}
