package org.example.usecase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.request.TicketingAlertReservationDomainRequest;
import org.example.entity.BaseEntity;
import org.example.entity.TicketingAlert;
import org.example.repository.ticketing.TicketingAlertRepository;
import org.example.vo.TicketingAlertTime;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void alertReservation(
        TicketingAlertReservationDomainRequest ticketingAlertReservation
    ) {
        List<TicketingAlert> existingAlerts = ticketingAlertRepository.findAllByUserIdAndShowIdAndIsDeletedFalse(
            ticketingAlertReservation.userId(),
            ticketingAlertReservation.showId()
        );

        List<LocalDateTime> requestedAlertTimes = ticketingAlertReservation.alertTimes().stream()
            .map(alertTime -> calculateAlertTime(ticketingAlertReservation.ticketingAt(), alertTime))
            .toList();

        List<TicketingAlert> alertsToKeep = existingAlerts.stream()
            .filter(alert -> requestedAlertTimes.contains(alert.getAlertTime()))
            .toList();

        List<LocalDateTime> existingAlertTimes = alertsToKeep.stream()
            .map(TicketingAlert::getAlertTime)
            .toList();

        addAlerts(ticketingAlertReservation, requestedAlertTimes, existingAlertTimes);
        removeAlerts(existingAlerts, requestedAlertTimes);
    }

    private void addAlerts(
        TicketingAlertReservationDomainRequest ticketingAlertReservation,
        List<LocalDateTime> requestedAlertTimes,
        List<LocalDateTime> existingAlertTimes
    ) {
        List<TicketingAlert> alertsToAdd = requestedAlertTimes.stream()
            .filter(alertTime -> !existingAlertTimes.contains(alertTime))
            .map(alertTime -> TicketingAlert.builder()
                .name(ticketingAlertReservation.name())
                .alertTime(alertTime)
                .userId(ticketingAlertReservation.userId())
                .showId(ticketingAlertReservation.showId())
                .build()
            )
            .toList();
        ticketingAlertRepository.saveAll(alertsToAdd);
    }

    private void removeAlerts(
        List<TicketingAlert> existingAlerts,
        List<LocalDateTime> requestedAlertTimes
    ) {
        List<TicketingAlert> alertsToRemove = existingAlerts.stream()
            .filter(alert -> !requestedAlertTimes.contains(alert.getAlertTime()))
            .toList();
        alertsToRemove.forEach(BaseEntity::softDelete);
    }

    private LocalDateTime calculateAlertTime(LocalDateTime showTime, TicketingAlertTime alertTime) {
        return switch (alertTime) {
            case BEFORE_24 -> showTime.minusHours(24);
            case BEFORE_6 -> showTime.minusHours(6);
            case BEFORE_1 -> showTime.minusHours(1);
        };
    }
}
