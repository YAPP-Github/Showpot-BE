package com.example.show.controller.vo;

import java.time.LocalDateTime;
import java.util.Map;

public record TicketingApiType(
    LocalDateTime ticketOpenTime,
    Map<String, String> ticketingInformation
) {

}
