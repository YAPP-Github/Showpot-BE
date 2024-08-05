package com.example.show.service.dto.response;

import com.example.show.controller.vo.TicketingApiType;
import java.time.LocalDate;
import lombok.Builder;
import org.example.dto.show.response.ShowTicketingTimeDomainResponse;

@Builder
public record ShowTicketingTimeServiceResponse(
    TicketingApiType ticketingApiType,
    LocalDate ticketingAt
) {

    public static ShowTicketingTimeServiceResponse from(ShowTicketingTimeDomainResponse response) {
        return ShowTicketingTimeServiceResponse.builder()
            .ticketingApiType(TicketingApiType.from(response.ticketingType()))
            .ticketingAt(response.ticketingAt())
            .build();
    }
}
