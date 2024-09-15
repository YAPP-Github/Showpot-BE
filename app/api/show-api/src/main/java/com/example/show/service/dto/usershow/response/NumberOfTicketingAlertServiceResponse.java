package com.example.show.service.dto.usershow.response;

public record NumberOfTicketingAlertServiceResponse(
    long count
) {

    public static NumberOfTicketingAlertServiceResponse from(long count) {
        return new NumberOfTicketingAlertServiceResponse(count);
    }
}
