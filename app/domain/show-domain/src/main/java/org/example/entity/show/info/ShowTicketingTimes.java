package org.example.entity.show.info;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.example.vo.TicketingType;

public class ShowTicketingTimes {

    private final Map<TicketingType, LocalDateTime> ticketingTimeByType = new HashMap<>();

    public void saveTicketingTimes(TicketingType ticketingType, LocalDateTime date) {
        ticketingTimeByType.put(ticketingType, date);
    }

    public Map<TicketingType, LocalDateTime> getTicketingTimeByType() {
        return new HashMap<>(ticketingTimeByType);
    }

    public LocalDateTime getLastTicketingDateTime() {
        return ticketingTimeByType.values().stream()
            .max(LocalDateTime::compareTo)
            .orElseThrow(NoSuchElementException::new);
    }
}
