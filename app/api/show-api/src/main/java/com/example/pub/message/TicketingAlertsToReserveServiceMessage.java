package com.example.pub.message;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.usershow.response.TicketingAlertsDomainResponse;

@Builder
public record TicketingAlertsToReserveServiceMessage(
    String userFcmToken,
    String name,
    UUID showId,
    List<TicketingTimeServiceMessage> addAts,
    List<TicketingTimeServiceMessage> deleteAts
) {

    public static TicketingAlertsToReserveServiceMessage of(
        TicketingAlertsDomainResponse responses,
        String userFcmToken
    ) {
        return TicketingAlertsToReserveServiceMessage.builder()
            .userFcmToken(userFcmToken)
            .name(responses.name())
            .showId(responses.showId())
            .addAts(responses.addAts().stream().map(TicketingTimeServiceMessage::from).toList())
            .deleteAts(
                responses.deleteAts().stream().map(TicketingTimeServiceMessage::from).toList())
            .build();
    }
}
