package org.example.service.dto.response;

public record NumberOfInterestShowServiceResponse(
    long count
) {

    public static NumberOfInterestShowServiceResponse from(long count) {
        return new NumberOfInterestShowServiceResponse(count);
    }
}
