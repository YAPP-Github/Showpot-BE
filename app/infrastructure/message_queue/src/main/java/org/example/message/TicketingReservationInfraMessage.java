package org.example.message;

import com.example.mq.message.TicketingReservationServiceMessage;
import java.util.List;
import lombok.Builder;

@Builder
public record TicketingReservationInfraMessage(
    String userFcmToken,
    List<ReserveShowInfraMessage> reserveShows
) {

    public static TicketingReservationInfraMessage from(
        TicketingReservationServiceMessage message
    ) {
        return TicketingReservationInfraMessage.builder()
            .userFcmToken(message.userFcmToken())
            .reserveShows(message.reserveShows()
                .stream()
                .map(ReserveShowInfraMessage::from)
                .toList()
            )
            .build();
    }
}
