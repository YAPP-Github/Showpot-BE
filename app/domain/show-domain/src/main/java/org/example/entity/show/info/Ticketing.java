package org.example.entity.show.info;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.annotations.Type;

@Embeddable
public class Ticketing {

    @Column(name = "ticket_open_time", nullable = false)
    private LocalDateTime ticketOpenTime;

    @Type(JsonType.class)
    @Column(name = "ticketing", columnDefinition = "jsonb", nullable = false)
    private Map<String, String> ticketingInformation = new HashMap<>();

    public void saveTicketOpenTime(LocalDateTime ticketOpenTime) {
        this.ticketOpenTime = ticketOpenTime;
    }

    public void saveTicketingInformation(
        String ticketBookingSite,
        String ticketingSiteUrl
    ) {
        ticketingInformation.put(ticketBookingSite, ticketingSiteUrl);
    }
}
