package com.example.show.controller.vo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import org.example.vo.TicketingAlertTime;

public enum TicketingAlertTimeApiType {
    BEFORE_24(24),
    BEFORE_6(6),
    BEFORE_1(1);

    private final int time;

    TicketingAlertTimeApiType(int time) {
        this.time = time;
    }

    public TicketingAlertTime toDomainType() {
        return switch (this) {
            case BEFORE_24 -> TicketingAlertTime.BEFORE_24;
            case BEFORE_6 -> TicketingAlertTime.BEFORE_6;
            case BEFORE_1 -> TicketingAlertTime.BEFORE_1;
        };
    }

    public static List<TicketingAlertTime> availableReserveTimeToDomainType(LocalDateTime ticketingAt) {
        long hoursDifference = Duration.between(LocalDateTime.now(), ticketingAt).toHours();

        return ALL_ALERT_TIMES.stream()
            .filter(alertTime -> {
                return switch (alertTime) {
                    case BEFORE_24 -> hoursDifference >= 24;
                    case BEFORE_6 -> hoursDifference >= 6;
                    case BEFORE_1 -> hoursDifference >= 1;
                };
            })
            .toList();
    }

    private static final List<TicketingAlertTime> ALL_ALERT_TIMES = List.of(
        TicketingAlertTime.BEFORE_24,
        TicketingAlertTime.BEFORE_6,
        TicketingAlertTime.BEFORE_1
    );

}
