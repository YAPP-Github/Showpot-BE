package org.example.message;

import com.example.publish.message.ReserveShowServiceMessage;
import com.example.show.controller.vo.TicketingApiType;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ReserveShowInfraMessage(
    LocalDateTime reserveAt,
    String showName,
    TicketingApiType type,
    UUID showId
) {
    public static ReserveShowInfraMessage from(ReserveShowServiceMessage message) {
        return ReserveShowInfraMessage.builder()
            .reserveAt(message.reserveAt())
            .showName(message.showName())
            .type(message.type())
            .showId(message.showId())
            .build();
    }

}
