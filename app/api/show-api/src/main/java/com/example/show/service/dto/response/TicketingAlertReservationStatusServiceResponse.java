package com.example.show.service.dto.response;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;

@Builder
public record TicketingAlertReservationStatusServiceResponse(
    boolean before24,
    boolean before6,
    boolean before1
) {

    public static TicketingAlertReservationStatusServiceResponse as(
        List<LocalDateTime> reservedAlerts,
        LocalDateTime ticketingAt
    ) {
        boolean before24 = false;
        boolean before6 = false;
        boolean before1 = false;

        for (LocalDateTime alertTime : reservedAlerts) {
            long hoursDifference = Duration.between(alertTime, ticketingAt).toHours();

            switch ((int) hoursDifference) {
                case 24 -> before24 = true;
                case 6 -> before6 = true;
                case 1 -> before1 = true;
                default -> {

                }
            }
        }

        return TicketingAlertReservationStatusServiceResponse.builder()
            .before24(before24)
            .before6(before6)
            .before1(before1)
            .build();
    }

}
