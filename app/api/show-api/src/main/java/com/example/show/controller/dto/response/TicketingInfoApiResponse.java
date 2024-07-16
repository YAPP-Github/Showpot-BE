package com.example.show.controller.dto.response;

import java.time.LocalDateTime;
import java.util.Map;
import org.example.entity.show.info.Ticketing;

public record TicketingInfoApiResponse(
    LocalDateTime ticketOpenTime,
    Map<String, String> ticketingInformation
) {

    public static TicketingInfoApiResponse from(Ticketing ticketing) {
        return new TicketingInfoApiResponse(
            ticketing.getTicketOpenTime(),
            ticketing.getTicketingInformation()
        );
    }

}
