package com.example.show.controller.dto.response;

import com.example.show.controller.vo.TicketingApiType;
import com.example.show.service.dto.response.ShowTicketingTimeServiceResponse;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record ShowTicketingTimeApiResponse(
    TicketingApiType ticketingApiType,
    LocalDateTime ticketingAt
) {

    public static ShowTicketingTimeApiResponse from(ShowTicketingTimeServiceResponse response) {
        return ShowTicketingTimeApiResponse.builder()
            .ticketingApiType(response.ticketingApiType())
            .ticketingAt(response.ticketingAt())
            .build();
    }
}
