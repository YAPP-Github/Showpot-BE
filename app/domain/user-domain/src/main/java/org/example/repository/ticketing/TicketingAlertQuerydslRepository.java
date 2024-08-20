package org.example.repository.ticketing;

import java.util.List;
import java.util.UUID;

public interface TicketingAlertQuerydslRepository {

    List<UUID> findAlertShowIdsByUserId(UUID userId);
}
