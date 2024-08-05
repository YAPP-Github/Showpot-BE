package org.example.entity.show.info;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.example.vo.TicketingType;

public class ShowTicketingTimes {

    private final Map<TicketingType, LocalDate> ticketingTimeByType = new HashMap<>();

    public void saveTicketingTimes(TicketingType ticketingType, LocalDate date) {
        ticketingTimeByType.put(ticketingType, date);
    }

    public Map<TicketingType, LocalDate> getTicketingTimeByType() {
        return new HashMap<>(ticketingTimeByType);
    }
}
