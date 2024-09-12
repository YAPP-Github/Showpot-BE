package com.example.show.service.dto.usershow.response;

public record NumberOfInterestShowServiceResponse(
    long count
) {

    public static NumberOfInterestShowServiceResponse from(long count) {
        return new NumberOfInterestShowServiceResponse(count);
    }
}
