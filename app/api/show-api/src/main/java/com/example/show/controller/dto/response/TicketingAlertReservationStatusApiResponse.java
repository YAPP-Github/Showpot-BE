package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.TicketingAlertReservationStatusServiceResponse;
import lombok.Builder;

@Builder
public record TicketingAlertReservationStatusApiResponse(
    boolean before24,
    boolean before6,
    boolean before1
) {

    public static TicketingAlertReservationStatusApiResponse from(
        TicketingAlertReservationStatusServiceResponse response
    ) {
        return TicketingAlertReservationStatusApiResponse.builder()
            .before24(response.before24())
            .before6(response.before6())
            .before1(response.before1())
            .build();
    }
}
