package com.example.show.controller.dto.response;

public record TicketingSiteApiResponse(
    String name,
    String link
) {
    public static TicketingSiteApiResponse of(String name, String link) {
        return new TicketingSiteApiResponse(name, link);
    }

}
