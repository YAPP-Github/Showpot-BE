package org.example.message;

import com.example.publish.message.TicketingAlertServiceMessage;
import java.util.UUID;
import lombok.Builder;

@Builder
public record TicketingAlertInfraMessage(
    String reserveAt,
    String showName,
    UUID showId
) {

    public static TicketingAlertInfraMessage from(TicketingAlertServiceMessage message) {
        return TicketingAlertInfraMessage.builder()
            .reserveAt(message.reserveAt().toString())
            .showName(message.name())
            .showId(message.showId())
            .build();
    }

}
