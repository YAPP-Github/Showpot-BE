package org.example.repository.ticketing;

import java.util.List;
import java.util.UUID;
import org.example.dto.response.TicketingAlertsDomainResponse;

public interface TicketingAlertQuerydslRepository {

    List<TicketingAlertsDomainResponse> findTicketingAlertsWithUserFcmToken(
        UUID userId,
        UUID showId
    );
}
