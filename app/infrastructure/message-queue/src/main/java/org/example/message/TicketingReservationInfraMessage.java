package org.example.message;

import com.example.publish.message.TicketingAlertsToReserveServiceMessage;
import java.util.List;
import lombok.Builder;

@Builder
public record TicketingReservationInfraMessage(
    String userFcmToken,
    List<TicketingAlertInfraMessage> ticketingAlerts
) {

    public static TicketingReservationInfraMessage from(
        TicketingAlertsToReserveServiceMessage message
    ) {
        return TicketingReservationInfraMessage.builder()
            .userFcmToken(message.userFcmToken())
            .ticketingAlerts(message.ticketingAlerts().stream()
                .map(TicketingAlertInfraMessage::from)
                .toList()
            )
            .build();
    }
}
