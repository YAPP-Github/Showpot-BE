package org.example.entity.show.info;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.example.vo.TicketingType;

public class ShowTicketingTimes {

    private final Map<TicketingType, LocalDateTime> ticketingTimeByType = new HashMap<>();

    public void saveTicketingTimes(TicketingType ticketingType, LocalDateTime date) {
        ticketingTimeByType.put(ticketingType, date);
    }

    public Map<TicketingType, LocalDateTime> getTicketingTimeByType() {
        return new HashMap<>(ticketingTimeByType);
    }
}
