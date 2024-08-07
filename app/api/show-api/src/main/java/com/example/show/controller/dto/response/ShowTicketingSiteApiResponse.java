package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.ShowTicketingSiteServiceResponse;
import java.util.Map;
import lombok.Builder;

@Builder
public record ShowTicketingSiteApiResponse(
    Map<String, String> ticketingSites
) {

    public static ShowTicketingSiteApiResponse from(
        ShowTicketingSiteServiceResponse ticketingSites
    ) {
        return new ShowTicketingSiteApiResponse(ticketingSites.ticketingSites());
    }
}
