package org.example.controller.dto.response;

import org.example.service.dto.response.NumberOfInterestShowServiceResponse;

public record NumberOfInterestShowApiResponse(
    long count
) {

    public static NumberOfInterestShowApiResponse from(NumberOfInterestShowServiceResponse response) {
        return new NumberOfInterestShowApiResponse(response.count());
    }
}
