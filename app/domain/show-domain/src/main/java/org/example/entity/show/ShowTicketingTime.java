package org.example.entity.show;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.entity.BaseEntity;
import org.example.vo.TicketingType;

@Entity
@Table(name = "show_ticketing_time")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class ShowTicketingTime extends BaseEntity {

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketingType ticketingType;

    @Column(name = "ticketing_at", nullable = false)
    private LocalDate ticketingAt;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

    @Builder
    public ShowTicketingTime(TicketingType ticketingType, LocalDate ticketingAt, Show show) {
        this.ticketingType = ticketingType;
        this.ticketingAt = ticketingAt;
        this.show = show;
    }
}
