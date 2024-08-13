package org.example.usecase;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.entity.TicketingAlert;
import org.example.repository.ticketing.TicketingAlertRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketingAlertUseCase {

    private final TicketingAlertRepository ticketingAlertRepository;

    public List<TicketingAlert> findTicketingAlerts(
        UUID userId,
        UUID showId
    ) {
        return ticketingAlertRepository.findAllByUserIdAndShowIdAndIsDeletedFalse(userId, showId);
    }
}
