package com.example.show.controller.dto.param;

public record TicketingSiteApiParam(
    String name,
    String link
) {
    public static TicketingSiteApiParam of(String name, String link) {
        return new TicketingSiteApiParam(name, link);
    }

}
