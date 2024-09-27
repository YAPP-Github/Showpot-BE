package org.example.message;

import com.example.pub.message.TicketingAlertsToReserveServiceMessage;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record TicketingReservationInfraMessage(
    String userFcmToken,
    String name,
    UUID showId,
    List<TicketingTimeInfraMessage> addAts,
    List<TicketingTimeInfraMessage> deleteAts
) {

    public static TicketingReservationInfraMessage from(
        TicketingAlertsToReserveServiceMessage message
    ) {
        return TicketingReservationInfraMessage.builder()
            .userFcmToken(message.userFcmToken())
            .name(message.name())
            .showId(message.showId())
            .addAts(message.addAts().stream().map(TicketingTimeInfraMessage::from).toList())
            .deleteAts(message.deleteAts().stream().map(TicketingTimeInfraMessage::from).toList())
            .build();
    }
}
