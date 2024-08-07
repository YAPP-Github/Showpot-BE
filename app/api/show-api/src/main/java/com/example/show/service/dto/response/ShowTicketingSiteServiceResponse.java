package com.example.show.service.dto.response;

import java.util.Map;
import lombok.Builder;
import org.example.entity.show.info.TicketingSites;

@Builder
public record ShowTicketingSiteServiceResponse(
    Map<String, String> ticketingSites
) {

    public static ShowTicketingSiteServiceResponse from(TicketingSites ticketingSites) {
        return new ShowTicketingSiteServiceResponse(ticketingSites.getTicketingURLBySite());
    }
}
