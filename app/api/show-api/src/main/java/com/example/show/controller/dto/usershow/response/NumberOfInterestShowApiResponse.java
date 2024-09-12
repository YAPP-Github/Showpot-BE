package com.example.show.controller.dto.usershow.response;


import com.example.show.service.dto.usershow.response.NumberOfInterestShowServiceResponse;

public record NumberOfInterestShowApiResponse(
    long count
) {

    public static NumberOfInterestShowApiResponse from(
        NumberOfInterestShowServiceResponse response
    ) {
        return new NumberOfInterestShowApiResponse(response.count());
    }
}
