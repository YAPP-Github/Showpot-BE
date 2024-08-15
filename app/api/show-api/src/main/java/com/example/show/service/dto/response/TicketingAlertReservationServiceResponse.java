package com.example.show.service.dto.response;

import lombok.Builder;

@Builder
public record TicketingAlertReservationServiceResponse(
    TicketingAlertReservationStatusServiceResponse alertReservationStatus,
    TicketingAlertReservationAvailabilityServiceResponse alertReservationAvailability
) {

    public static TicketingAlertReservationServiceResponse as(
        TicketingAlertReservationStatusServiceResponse alertReservationStatus,
        TicketingAlertReservationAvailabilityServiceResponse alertReservationAvailability
    ) {
        return TicketingAlertReservationServiceResponse.builder()
            .alertReservationStatus(alertReservationStatus)
            .alertReservationAvailability(alertReservationAvailability)
            .build();
    }

}
