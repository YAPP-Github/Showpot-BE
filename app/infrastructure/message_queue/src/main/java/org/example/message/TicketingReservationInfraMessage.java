package org.example.message;

import com.example.mq.message.TicketingReservationServiceMessage;
import com.example.show.controller.vo.TicketingApiType;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;

@Builder
public record TicketingReservationInfraMessage(
    LocalDateTime reserveAt,
    String showName,
    TicketingApiType type,
    UUID userId,
    UUID showId
) {

    public static TicketingReservationInfraMessage from(
        TicketingReservationServiceMessage message
    ) {
        return TicketingReservationInfraMessage.builder()
            .reserveAt(message.reserveAt())
            .showName(message.showName())
            .type(message.type())
            .userId(message.userId())
            .showId(message.showId())
            .build();
    }
}
