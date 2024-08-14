package com.example.publish.message;

import java.util.List;
import lombok.Builder;
import org.example.dto.response.TicketingAlertsDomainResponse;

@Builder
public record TicketingAlertsToReserveServiceMessage(
    String userFcmToken,
    List<TicketingAlertServiceMessage> ticketingAlerts
) {

    public static TicketingAlertsToReserveServiceMessage from(
        List<TicketingAlertsDomainResponse> responses
    ) {
        String userFcmToken = responses.get(0).userFcmToken();

        return TicketingAlertsToReserveServiceMessage.builder()
            .userFcmToken(userFcmToken)
            .ticketingAlerts(responses.stream()
                .map(TicketingAlertServiceMessage::from)
                .toList()
            )
            .build();
    }
}
