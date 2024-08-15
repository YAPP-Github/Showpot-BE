package com.example.show.service.dto.response;

import java.time.Duration;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record TicketingAlertReservationAvailabilityServiceResponse(
    boolean canReserve24,
    boolean canReserve6,
    boolean canReserve1
) {

    public static TicketingAlertReservationAvailabilityServiceResponse as(LocalDateTime ticketingAt) {
        LocalDateTime now = LocalDateTime.now();
        long hoursDifference = Duration.between(now, ticketingAt).toHours();

        boolean canReserve24 = hoursDifference >= 24;
        boolean canReserve6 = hoursDifference >= 6;
        boolean canReserve1 = hoursDifference >= 1;

        return TicketingAlertReservationAvailabilityServiceResponse.builder()
            .canReserve24(canReserve24)
            .canReserve6(canReserve6)
            .canReserve1(canReserve1)
            .build();
    }
}
