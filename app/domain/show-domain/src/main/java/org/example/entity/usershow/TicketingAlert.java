package org.example.entity.usershow;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ticketing_alert")
public class TicketingAlert extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "schedule_alert_time", nullable = false)
    private LocalDateTime alertTime;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "show_id", nullable = false)
    private UUID showId;

    @Builder
    private TicketingAlert(
        String name,
        LocalDateTime alertTime,
        UUID userId,
        UUID showId
    ) {
        this.name = name;
        this.alertTime = alertTime;
        this.userId = userId;
        this.showId = showId;
    }
}
