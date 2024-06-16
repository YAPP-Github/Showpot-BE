package com.example.show.controller.dto.response;

public record TicketingAndShowInfoApiResponse(
    String ticketingDateTime,
    String showDateTime,
    String ticketingURL
) {

}
