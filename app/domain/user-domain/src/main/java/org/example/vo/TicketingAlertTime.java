package org.example.vo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public enum TicketingAlertTime {
    BEFORE_A_DAY(24),
    BEFORE_SIX_HOURS(6),
    BEFORE_A_HOUR(1);

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
