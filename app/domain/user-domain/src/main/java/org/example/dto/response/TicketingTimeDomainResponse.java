package org.example.dto.response;

import java.time.LocalDateTime;
import lombok.Builder;
import org.example.vo.TicketingAlertTime;

@Builder
public record TicketingTimeDomainResponse(
    LocalDateTime alertAt,
    TicketingAlertTime time
) {

    public static TicketingTimeDomainResponse from(
        LocalDateTime ticketingAt,
        LocalDateTime alertAt
    ) {
        return TicketingTimeDomainResponse.builder()
            .alertAt(alertAt)
            .time(TicketingAlertTime.getAlertTime(ticketingAt, alertAt))
            .build();
    }

}
