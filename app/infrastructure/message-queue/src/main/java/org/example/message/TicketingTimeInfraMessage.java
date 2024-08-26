package org.example.message;

import com.example.publish.message.TicketingTimeServiceMessage;
import com.example.show.controller.vo.TicketingAlertTimeApiType;
import lombok.Builder;

@Builder
public record TicketingTimeInfraMessage(
    String alertAt,
    TicketingAlertTimeApiType time
) {

    public static TicketingTimeInfraMessage from(
        TicketingTimeServiceMessage message
    ) {
        return TicketingTimeInfraMessage.builder()
            .alertAt(message.alertAt().toString())
            .time(message.time())
            .build();
    }

}
