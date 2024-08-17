package org.example.controller.dto.response;

import org.example.service.dto.response.TicketingAlertCountServiceResponse;

public record TicketingAlertCountApiResponse(
    long count
) {

    public static TicketingAlertCountApiResponse from(TicketingAlertCountServiceResponse response) {
        return new TicketingAlertCountApiResponse(response.count());
    }
}
