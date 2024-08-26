package org.example.vo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public enum TicketingAlertTime {
    BEFORE_24(24),
    BEFORE_6(6),
    BEFORE_1(1);

    private final long time;

    TicketingAlertTime(long time) {
        this.time = time;
    }

    public static TicketingAlertTime getAlertTime(LocalDateTime ticketingAt, LocalDateTime alertAt) {
        long hoursDifference = Duration.between(alertAt, ticketingAt).toHours();

        return Arrays.stream(TicketingAlertTime.values())
            .filter(alertTime -> alertTime.time == hoursDifference)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("일치하지 않은 시간입니다.: " + hoursDifference));
    }
}
