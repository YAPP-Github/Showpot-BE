package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.TicketingAlertReservationAvailabilityServiceResponse;
import lombok.Builder;

@Builder
public record TicketingAlertReservationAvailabilityApiResponse(
    boolean canReserve24,
    boolean canReserve6,
    boolean canReserve1
) {

    public static TicketingAlertReservationAvailabilityApiResponse from(
        TicketingAlertReservationAvailabilityServiceResponse response
    ) {
        return TicketingAlertReservationAvailabilityApiResponse.builder()
            .canReserve24(response.canReserve24())
            .canReserve6(response.canReserve6())
            .canReserve1(response.canReserve1())
            .build();
    }
}
