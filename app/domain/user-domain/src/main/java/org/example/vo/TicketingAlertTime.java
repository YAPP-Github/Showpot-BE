package org.example.vo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public enum TicketingAlertTime {
    BEFORE_A_DAY(1440),
    BEFORE_SIX_HOURS(360),
    BEFORE_A_HOUR(60);

    private final long minutes;

    TicketingAlertTime(long minutes) {
        this.minutes = minutes;
    }

    public static TicketingAlertTime getAlertTime(LocalDateTime ticketingAt, LocalDateTime alertAt) {
        long minutesDifference = Duration.between(alertAt, ticketingAt).toMinutes();

        return Arrays.stream(TicketingAlertTime.values())
            .filter(alertTime -> alertTime.minutes == minutesDifference)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("일치하지 않은 시간입니다.: " + minutesDifference));
    }
}
