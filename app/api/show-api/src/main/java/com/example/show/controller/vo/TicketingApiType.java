package com.example.show.controller.vo;

import org.example.vo.TicketingType;

public enum TicketingApiType {
    PRE("선예매"), NORMAL("일반예매"), ADDITIONAL("추가예매");

    TicketingApiType(String value) {
    }

    public static TicketingApiType from(TicketingType ticketingType) {
        return switch (ticketingType) {
            case PRE -> PRE;
            case NORMAL -> NORMAL;
            case ADDITIONAL -> ADDITIONAL;
        };
    }

    public TicketingType toDomainType() {
        return switch (this) {
            case PRE -> TicketingType.PRE;
            case NORMAL -> TicketingType.NORMAL;
            case ADDITIONAL -> TicketingType.ADDITIONAL;
        };
    }
}
