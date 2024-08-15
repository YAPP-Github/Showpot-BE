package com.example.show.controller.dto.response;

import com.example.show.controller.vo.TicketingApiType;
import com.example.show.service.dto.response.ShowTicketingTimeServiceParam;
import lombok.Builder;
import org.example.util.DateTimeUtil;

@Builder
public record ShowTicketingTimePaginationApiParam(
    TicketingApiType ticketingType,
    String ticketingAt
) {

    public static ShowTicketingTimePaginationApiParam from(ShowTicketingTimeServiceParam response) {
        return ShowTicketingTimePaginationApiParam.builder()
            .ticketingType(response.ticketingType())
            .ticketingAt(DateTimeUtil.formatDateTime(response.ticketingAt()))
            .build();
    }
}
