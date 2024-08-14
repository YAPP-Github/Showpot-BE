package com.example.publish.message;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.response.TicketingAlertsDomainResponse;

@Builder
public record TicketingAlertServiceMessage(
    String name,
    LocalDateTime reserveAt,
    UUID showId
) {
    public static TicketingAlertServiceMessage from(
        TicketingAlertsDomainResponse response
    ) {
        return TicketingAlertServiceMessage.builder()
            .name(response.name())
            .reserveAt(response.reservedAt())
            .showId(response.showId())
            .build();
    }

}
