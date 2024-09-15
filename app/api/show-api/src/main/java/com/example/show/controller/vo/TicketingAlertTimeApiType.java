package com.example.show.controller.vo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import org.example.vo.TicketingAlertTime;

@Getter
public enum TicketingAlertTimeApiType {
    BEFORE_A_DAY(1440),
    BEFORE_SIX_HOURS(360),
    BEFORE_A_HOUR(60);

    private final int minutes;

    TicketingAlertTimeApiType(int minutes) {
        this.minutes = minutes;
    }

    public TicketingAlertTime toDomainType() {
        return switch (this) {
            case BEFORE_A_DAY -> TicketingAlertTime.BEFORE_A_DAY;
            case BEFORE_SIX_HOURS -> TicketingAlertTime.BEFORE_SIX_HOURS;
            case BEFORE_A_HOUR -> TicketingAlertTime.BEFORE_A_HOUR;
        };
    }

    public static TicketingAlertTimeApiType getTicketingAlertTime(TicketingAlertTime alertTime) {
        return switch (alertTime) {
            case BEFORE_A_DAY -> TicketingAlertTimeApiType.BEFORE_A_DAY;
            case BEFORE_SIX_HOURS -> TicketingAlertTimeApiType.BEFORE_SIX_HOURS;
            case BEFORE_A_HOUR -> TicketingAlertTimeApiType.BEFORE_A_HOUR;
        };
    }

    public static TicketingAlertTimeApiType getTicketingAlertTimeByMinutesGap(int minutes) {
        return Arrays.stream(TicketingAlertTimeApiType.values())
            .filter(alertTime -> alertTime.minutes == minutes)
            .findFirst()
            .orElse(null);
    }

    public static List<TicketingAlertTime> availableReserveTimeToDomainType(
        LocalDateTime ticketingAt,
        List<TicketingAlertTimeApiType> alertTimes
    ) {
        long minutesDifference = Duration.between(LocalDateTime.now(), ticketingAt).toMinutes();

        return alertTimes.stream()
            .filter(alertTime -> switch (alertTime) {
                case BEFORE_A_DAY, BEFORE_SIX_HOURS, BEFORE_A_HOUR -> minutesDifference >= alertTime.minutes;
            })
            .map(TicketingAlertTimeApiType::toDomainType)
            .toList();
    }
}
