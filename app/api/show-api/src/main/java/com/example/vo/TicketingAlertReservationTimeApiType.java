package com.example.vo;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum TicketingAlertReservationTimeApiType {
    BEFORE_ONE_HOUR(60),
    BEFORE_SIX_HOUR(360),
    BEFORE_A_DAY(1440);

    private final int minutes;

    TicketingAlertReservationTimeApiType(int minutes) {
        this.minutes = minutes;
    }

    public static TicketingAlertReservationTimeApiType getTicketingAlertReservationTime(int minutes) {
        return Arrays.stream(TicketingAlertReservationTimeApiType.values())
            .filter(alertTime -> alertTime.minutes == minutes)
            .findFirst()
            .orElse(null);
    }
}
