package com.example.publish.message;

import com.example.show.controller.vo.TicketingAlertTimeApiType;
import java.time.LocalDateTime;
import lombok.Builder;
import org.example.dto.usershow.response.TicketingTimeDomainResponse;

@Builder
public record TicketingTimeServiceMessage(
    LocalDateTime alertAt,
    TicketingAlertTimeApiType time
) {

    public static TicketingTimeServiceMessage from(
        TicketingTimeDomainResponse response
    ) {
        return TicketingTimeServiceMessage.builder()
            .alertAt(response.alertAt())
            .time(TicketingAlertTimeApiType.getTicketingAlertTime(response.time()))
            .build();
    }
}
