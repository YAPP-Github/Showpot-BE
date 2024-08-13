package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.TicketingAlertReservationServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record TicketingAlertReservationApiResponse(
    @Schema(description = "공연 알림 예약 상태")
    TicketingAlertReservationStatusApiResponse alertReservationStatus,

    @Schema(description = "공연 알림 예약 가능 여부")
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
