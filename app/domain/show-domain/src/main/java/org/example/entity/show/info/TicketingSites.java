package org.example.entity.show.info;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.HashMap;
import java.util.Map;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Embeddable
@NoArgsConstructor
public class TicketingSites {

    @Type(JsonType.class)
    @Column(name = "ticketing_sites", columnDefinition = "jsonb", nullable = false)
    private Map<String, String> ticketingURLBySite = new HashMap<>();

    public void saveTicketingSite(String ticketingSite, String ticketingURL) {
        ticketingURLBySite.put(ticketingSite, ticketingURL);
    }

    public Map<String, String> getTicketingURLBySite() {
        return new HashMap<>(ticketingURLBySite);
    }
}
