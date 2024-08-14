package com.example.show.controller.vo;

import org.example.vo.TicketingAlertTime;

public enum TicketingAlertTimeApiType {
    BEFORE_24,
    BEFORE_6,
    BEFORE_1;

    public TicketingAlertTime toDomainType() {
        return switch (this) {
            case BEFORE_24 -> TicketingAlertTime.BEFORE_24;
            case BEFORE_6 -> TicketingAlertTime.BEFORE_6;
            case BEFORE_1 -> TicketingAlertTime.BEFORE_1;
        };
    }
}
