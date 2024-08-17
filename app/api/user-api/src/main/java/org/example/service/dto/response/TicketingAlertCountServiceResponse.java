package org.example.service.dto.response;

public record TicketingAlertCountServiceResponse(
    long count
) {

    public static TicketingAlertCountServiceResponse from(long count) {
        return new TicketingAlertCountServiceResponse(count);
    }
}
