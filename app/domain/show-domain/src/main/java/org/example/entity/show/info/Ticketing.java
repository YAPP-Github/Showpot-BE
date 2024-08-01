package org.example.entity.show.info;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.UUID;
import org.example.entity.BaseEntity;
import org.example.vo.TicketingType;

@Entity
public class Ticketing extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketingType type;

    @Column(name = "ticket_open_time", nullable = false)
    private LocalDateTime ticketOpenTime;

    @Column(nullable = false)
    private UUID showId;

    public void saveTicketOpenTime(LocalDateTime ticketOpenTime) {
        this.ticketOpenTime = ticketOpenTime;
    }

    public LocalDateTime getTicketOpenTime() {
        return ticketOpenTime;
    }
}
