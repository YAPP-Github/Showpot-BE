package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.TicketingAlertReservationServiceResponse;
import lombok.Builder;

@Builder
public record TicketingAlertReservationApiResponse(
    TicketingAlertReservationStatusApiResponse alertReservationStatus,
    TicketingAlertReservationAvailabilityApiResponse alertReservationAvailability
) {
    public static TicketingAlertReservationApiResponse from(
        TicketingAlertReservationServiceResponse response
    ) {
        var alertReservationStatus = TicketingAlertReservationStatusApiResponse.from(
            response.alertReservationStatus()
        );
        var alertReservationAvailability = TicketingAlertReservationAvailabilityApiResponse.from(
            response.alertReservationAvailability()
        );

        return TicketingAlertReservationApiResponse.builder()
            .alertReservationStatus(alertReservationStatus)
            .alertReservationAvailability(alertReservationAvailability)
            .build();
    }

}
