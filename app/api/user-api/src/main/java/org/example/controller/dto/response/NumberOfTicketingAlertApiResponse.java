package org.example.controller.dto.response;

import org.example.service.dto.response.NumberOfTicketingAlertServiceResponse;

public record NumberOfTicketingAlertApiResponse(
    long count
) {

    public static NumberOfTicketingAlertApiResponse from(NumberOfTicketingAlertServiceResponse response) {
        return new NumberOfTicketingAlertApiResponse(response.count());
    }
}
