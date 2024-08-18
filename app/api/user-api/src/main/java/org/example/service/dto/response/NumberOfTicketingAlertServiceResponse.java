package org.example.service.dto.response;

public record NumberOfTicketingAlertServiceResponse(
    long count
) {

    public static NumberOfTicketingAlertServiceResponse from(long count) {
        return new NumberOfTicketingAlertServiceResponse(count);
    }
}
