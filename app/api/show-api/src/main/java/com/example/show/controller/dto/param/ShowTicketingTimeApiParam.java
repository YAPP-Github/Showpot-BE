package com.example.show.controller.dto.param;

import com.example.show.controller.vo.TicketingApiType;
import com.example.show.service.dto.param.ShowTicketingTimeServiceParam;
import lombok.Builder;
import org.example.util.DateTimeUtil;

@Builder
public record ShowTicketingTimeApiParam(
    TicketingApiType ticketingApiType,
    String ticketingAt
) {

    public static ShowTicketingTimeApiParam from(ShowTicketingTimeServiceParam response) {
        return ShowTicketingTimeApiParam.builder()
            .ticketingApiType(response.ticketingType())
            .ticketingAt(DateTimeUtil.formatDateTime(response.ticketingAt()))
            .build();
    }
}
