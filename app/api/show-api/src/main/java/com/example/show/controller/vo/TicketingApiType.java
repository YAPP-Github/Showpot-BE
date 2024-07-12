package com.example.show.controller.vo;

import java.time.LocalDateTime;
import java.util.Map;
import org.example.entity.show.info.Ticketing;

public record TicketingApiType(
    LocalDateTime ticketOpenTime,
    Map<String, String> ticketingInformation
) {

    public static TicketingApiType from(Ticketing ticketing) {
        return new TicketingApiType(
            ticketing.getTicketOpenTime(),
            ticketing.getTicketingInformation()
        );
    }

}
