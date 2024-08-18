package org.example.controller.dto.response;

import org.example.service.dto.response.NumberOfSubscribedGenreServiceResponse;

public record NumberOfSubscribedGenreApiResponse(
    long count
) {

    public static NumberOfSubscribedGenreApiResponse from(NumberOfSubscribedGenreServiceResponse response) {
        return new NumberOfSubscribedGenreApiResponse(response.count());
    }
}
