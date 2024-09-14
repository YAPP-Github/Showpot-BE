package com.example.show.service;

import com.example.publish.MessagePublisher;
import com.example.publish.message.TicketingAlertsToReserveServiceMessage;
import com.example.show.controller.vo.TicketingApiType;
import com.example.show.error.ShowError;
import com.example.show.service.dto.param.ShowAlertPaginationServiceParam;
import com.example.show.service.dto.request.InterestShowPaginationServiceRequest;
import com.example.show.service.dto.request.ShowAlertPaginationServiceRequest;
import com.example.show.service.dto.request.ShowInterestServiceRequest;
import com.example.show.service.dto.request.TicketingAlertReservationServiceRequest;
import com.example.show.service.dto.response.InterestShowPaginationServiceResponse;
import com.example.show.service.dto.response.ShowInterestServiceResponse;
import com.example.show.service.dto.response.TerminatedTicketingShowCountServiceResponse;
import com.example.show.service.dto.response.TicketingAlertReservationAvailabilityServiceResponse;
import com.example.show.service.dto.response.TicketingAlertReservationServiceResponse;
import com.example.show.service.dto.response.TicketingAlertReservationStatusServiceResponse;
import com.example.show.service.dto.usershow.response.NumberOfInterestShowServiceResponse;
import com.example.show.service.dto.usershow.response.NumberOfTicketingAlertServiceResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.PaginationServiceResponse;
import org.example.dto.show.response.ShowAlertPaginationDomainResponse;
import org.example.entity.InterestShow;
import org.example.entity.TicketingAlert;
import org.example.entity.show.Show;
import org.example.entity.show.ShowTicketingTime;
import org.example.exception.BusinessException;
import org.example.usecase.InterestShowUseCase;
import org.example.usecase.ShowUseCase;
import org.example.usecase.TicketingAlertUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserShowService {

    private final ShowUseCase showUseCase;
    private final TicketingAlertUseCase ticketingAlertUseCase;
    private final InterestShowUseCase interestShowUseCase;
    private final MessagePublisher messagePublisher;

    public ShowInterestServiceResponse interest(ShowInterestServiceRequest request) {
        Show show = showUseCase.findShowOrThrowNoSuchElementException(request.showId());

        return ShowInterestServiceResponse.from(
            interestShowUseCase.interest(request.toDomainRequest(show.getId()))
        );
    }

    public PaginationServiceResponse<InterestShowPaginationServiceResponse> findInterestShows(
        InterestShowPaginationServiceRequest request
    ) {
        var interestShows = interestShowUseCase.findInterestShows(request.toDomainRequest());
        List<UUID> showIds = interestShows.data().stream().map(InterestShow::getShowId).toList();
        Map<UUID, Show> showById = showUseCase.findShowsInIds(showIds).stream()
            .collect(Collectors.toMap(Show::getId, s -> s));

        return PaginationServiceResponse.of(
            interestShows.data().stream()
                .map(interestShow -> InterestShowPaginationServiceResponse.from(
                    showById.get(interestShow.getShowId()),
                    interestShow
                ))
                .toList(),
            interestShows.hasNext()
        );
    }

    public NumberOfInterestShowServiceResponse countInterestShows(UUID uuid) {
        return NumberOfInterestShowServiceResponse.from(
            interestShowUseCase.countInterestShows(uuid)
        );
    }

    public void alertReservation(
        TicketingAlertReservationServiceRequest ticketingAlertReservationRequest
    ) {
        ShowTicketingTime showTicketingTime = showUseCase.findTicketingTimeWithShow(
            ticketingAlertReservationRequest.showId(),
            ticketingAlertReservationRequest.type().toDomainType()
        );

        if (showTicketingTime.getTicketingAt().isBefore(LocalDateTime.now())) {
            throw new BusinessException(ShowError.TICKETING_ALERT_RESERVED_ERROR);
        }

        var domainResponse = ticketingAlertUseCase.alertReservation(
            ticketingAlertReservationRequest.toDomainRequest(
                showTicketingTime.getShow().getTitle(),
                showTicketingTime.getTicketingAt()
            )
        );
        messagePublisher.publishTicketingReservation(
            "ticketingAlert",
            TicketingAlertsToReserveServiceMessage.from(domainResponse)
        );
    }

    public PaginationServiceResponse<ShowAlertPaginationServiceParam> findAlertShows(
        ShowAlertPaginationServiceRequest request
    ) {
        List<TicketingAlert> ticketingAlerts = ticketingAlertUseCase.findTicketingAlertsByUserId(
            request.userId());
        List<UUID> showIdsToAlert = ticketingAlerts.stream()
            .map(TicketingAlert::getShowId)
            .distinct()
            .toList();

        ShowAlertPaginationDomainResponse alertShows = showUseCase.findAlertShows(
            request.toDomainRequest(showIdsToAlert, LocalDateTime.now()));

        return PaginationServiceResponse.of(alertShows.data().stream()
                .map(ShowAlertPaginationServiceParam::from)
                .toList(),
            alertShows.hasNext()
        );
    }

    public TicketingAlertReservationServiceResponse findAlertsReservations(
        UUID userId,
        UUID showId,
        TicketingApiType type
    ) {
        var ticketingAt = showUseCase
            .findTicketingAlertReservation(showId, type.toDomainType())
            .getTicketingAt();

        var reservedAlerts = ticketingAlertUseCase.findTicketingAlerts(userId, showId)
            .stream()
            .map(TicketingAlert::getAlertTime)
            .toList();

        var status = TicketingAlertReservationStatusServiceResponse.as(
            reservedAlerts,
            ticketingAt
        );
        var availability = TicketingAlertReservationAvailabilityServiceResponse.as(ticketingAt);

        return TicketingAlertReservationServiceResponse.as(status, availability);
    }

    public NumberOfTicketingAlertServiceResponse countAlertShows(UUID userId, LocalDateTime now) {
        long numberOfTicketingAlert = ticketingAlertUseCase.countAlertShows(userId, now);

        return NumberOfTicketingAlertServiceResponse.from(numberOfTicketingAlert);
    }

    public TerminatedTicketingShowCountServiceResponse countTerminatedTicketingShow(UUID userId) {
        List<TicketingAlert> ticketingAlerts = ticketingAlertUseCase.findTicketingAlertsByUserId(
            userId);
        List<UUID> showIdsToAlert = ticketingAlerts.stream()
            .map(TicketingAlert::getShowId)
            .distinct()
            .toList();

        if (showIdsToAlert.isEmpty()) {
            return TerminatedTicketingShowCountServiceResponse.noCount();
        }

        return TerminatedTicketingShowCountServiceResponse.from(
            showUseCase.findTerminatedTicketingShowsCount(showIdsToAlert, LocalDateTime.now())
        );
    }
}
