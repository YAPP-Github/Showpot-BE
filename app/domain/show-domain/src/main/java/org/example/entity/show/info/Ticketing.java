package org.example.entity.show.info;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.HashMap;
import java.util.Map;
import org.example.vo.TicketBookingSite;
import org.hibernate.annotations.Type;

@Embeddable
public class Ticketing {

    @Type(JsonType.class)
    @Column(name = "ticketing", columnDefinition = "jsonb", nullable = false)
    private Map<TicketBookingSite, String> ticketingInformation = new HashMap<>();

    public void saveTicketingInformation(
        TicketBookingSite ticketBookingSite,
        String ticketingSiteUrl
    ) {
        ticketingInformation.put(ticketBookingSite, ticketingSiteUrl);
    }
}
