package org.example.fixture.domain;

import java.time.LocalDateTime;
import org.example.entity.show.Show;
import org.example.entity.show.ShowTicketingTime;
import org.example.vo.TicketingType;

public class ShowTicketingTimeFixture {

    public static ShowTicketingTime showNormalTicketingTime(Show show) {
        return ShowTicketingTime.builder()
            .ticketingType(TicketingType.NORMAL)
            .ticketingAt(LocalDateTime.now())
            .show(show)
            .build();
    }

    public static ShowTicketingTime showPreTicketingTime(Show show) {
        return ShowTicketingTime.builder()
            .ticketingType(TicketingType.PRE)
            .ticketingAt(LocalDateTime.now())
            .show(show)
            .build();
    }

}
