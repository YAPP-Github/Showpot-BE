package com.example.mq.message;

import com.example.show.controller.vo.TicketingApiType;
import java.time.LocalDateTime;
import java.util.UUID;

public record ReserveShowServiceMessage(
    LocalDateTime reserveAt,
    String showName,
    TicketingApiType type,
    UUID showId
) {

}
