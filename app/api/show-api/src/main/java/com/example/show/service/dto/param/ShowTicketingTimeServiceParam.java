package com.example.show.service.dto.param;

import com.example.show.controller.vo.TicketingApiType;
import java.time.LocalDateTime;
import lombok.Builder;
import org.example.dto.show.response.ShowTicketingTimeDomainResponse;

@Builder
public record ShowTicketingTimeServiceParam(
    TicketingApiType ticketingType,
    LocalDateTime ticketingAt
) {

    public static ShowTicketingTimeServiceParam from(ShowTicketingTimeDomainResponse response) {
        return ShowTicketingTimeServiceParam.builder()
            .ticketingType(TicketingApiType.from(response.ticketingType()))
            .ticketingAt(response.ticketingAt())
            .build();
    }
}
