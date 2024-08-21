package com.example.show.vo;

import org.example.vo.ShowTicketingAtStatus;

public enum ShowTicketingAtStatusApiType {

    TERMINATED,
    CONTINUED;

    public ShowTicketingAtStatus toDomainType() {
        return switch (this) {
            case TERMINATED -> ShowTicketingAtStatus.TERMINATED;
            case CONTINUED -> ShowTicketingAtStatus.CONTINUED;
        };
    }
}
