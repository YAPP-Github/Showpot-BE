package org.example.repository.ticketing;

import java.time.LocalDateTime;
import java.util.UUID;

public interface TicketingAlertQuerydslRepository {

    long countValidTicketingAlerts(UUID userId, LocalDateTime now);
}
