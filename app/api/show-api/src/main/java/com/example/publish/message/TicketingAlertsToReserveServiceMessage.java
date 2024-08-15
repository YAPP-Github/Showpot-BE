package com.example.publish.message;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.response.TicketingAlertsDomainResponse;

@Builder
public record TicketingAlertsToReserveServiceMessage(
    String userFcmToken,
    String name,
    UUID showId,
    List<LocalDateTime> reserveAts
) {

    public static TicketingAlertsToReserveServiceMessage from(
        TicketingAlertsDomainResponse responses
    ) {
        return TicketingAlertsToReserveServiceMessage.builder()
            .userFcmToken(responses.userFcmToken())
            .name(responses.name())
            .showId(responses.showId())
            .reserveAts(responses.reservedAts())
            .build();
    }
}
