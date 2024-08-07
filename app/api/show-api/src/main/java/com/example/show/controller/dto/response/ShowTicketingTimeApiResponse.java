package com.example.show.controller.dto.response;

import com.example.show.controller.vo.TicketingApiType;
import com.example.show.service.dto.response.ShowTicketingTimeServiceResponse;
import lombok.Builder;
import org.example.util.DateTimeUtil;

@Builder
public record ShowTicketingTimeApiResponse(
    TicketingApiType ticketingApiType,
    String ticketingAt
) {

    public static ShowTicketingTimeApiResponse from(ShowTicketingTimeServiceResponse response) {
        return ShowTicketingTimeApiResponse.builder()
            .ticketingApiType(response.ticketingApiType())
            .ticketingAt(DateTimeUtil.formatLocalDateTime(response.ticketingAt()))
            .build();
    }
}
