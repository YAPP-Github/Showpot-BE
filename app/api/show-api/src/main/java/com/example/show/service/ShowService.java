package com.example.show.service;

import com.example.publish.MessagePublisher;
import com.example.publish.message.TicketingAlertsToReserveServiceMessage;
import com.example.show.controller.vo.TicketingApiType;
import com.example.show.error.ShowError;
import com.example.show.service.dto.param.ShowAlertPaginationServiceParam;
import com.example.show.service.dto.param.ShowSearchPaginationServiceParam;
import com.example.show.service.dto.request.InterestShowPaginationServiceRequest;
import com.example.show.service.dto.request.ShowAlertPaginationServiceRequest;
import com.example.show.service.dto.request.ShowInterestServiceRequest;
import com.example.show.service.dto.request.ShowPaginationServiceRequest;
import com.example.show.service.dto.request.ShowSearchPaginationServiceRequest;
import com.example.show.service.dto.request.TicketingAlertReservationServiceRequest;
import com.example.show.service.dto.response.InterestShowPaginationServiceResponse;
import com.example.show.service.dto.response.ShowDetailServiceResponse;
import com.example.show.service.dto.response.ShowInterestServiceResponse;
import com.example.show.service.dto.response.ShowPaginationServiceResponse;
import com.example.show.service.dto.response.TerminatedTicketingShowCountServiceResponse;
import com.example.show.service.dto.response.TicketingAlertReservationAvailabilityServiceResponse;
import com.example.show.service.dto.response.TicketingAlertReservationServiceResponse;
import com.example.show.service.dto.response.TicketingAlertReservationStatusServiceResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.PaginationServiceResponse;
import org.example.dto.show.response.ShowAlertPaginationDomainResponse;
import org.example.dto.show.response.ShowDetailDomainResponse;
import org.example.entity.InterestShow;
import org.example.entity.TicketingAlert;
import org.example.entity.show.Show;
import org.example.entity.show.ShowTicketingTime;
import org.example.exception.BusinessException;
import org.example.usecase.TicketingAlertUseCase;
import org.example.usecase.UserShowUseCase;
import org.example.usecase.show.ShowUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowUseCase showUseCase;
    private final TicketingAlertUseCase ticketingAlertUseCase;
    private final UserShowUseCase userShowUseCase;
    private final MessagePublisher messagePublisher;


    public ShowDetailServiceResponse getShow(UUID id) {
        ShowDetailDomainResponse showDetail;
        try {
            showDetail = showUseCase.findShowDetail(id);
        } catch (NoSuchElementException e) {
            throw new BusinessException(ShowError.ENTITY_NOT_FOUND);
        }

        return ShowDetailServiceResponse.from(showDetail);
    }

    public PaginationServiceResponse<ShowSearchPaginationServiceParam> searchShow(
        ShowSearchPaginationServiceRequest request
    ) {
        var response = showUseCase.searchShow(request.toDomainRequest());

        List<ShowSearchPaginationServiceParam> data = response.data().stream()
            .map(ShowSearchPaginationServiceParam::from)
            .toList();

        return PaginationServiceResponse.of(data, response.hasNext());
    }

    public PaginationServiceResponse<ShowPaginationServiceResponse> findShows(
        ShowPaginationServiceRequest request
    ) {
        var response = showUseCase.findShows(request.toDomainRequest());
        var data = response.data().stream()
            .map(
                domainResponse -> ShowPaginationServiceResponse.from(domainResponse, request.now()))
            .toList();

        return PaginationServiceResponse.of(
            data,
            response.hasNext()
        );
    }

    public PaginationServiceResponse<InterestShowPaginationServiceResponse> findInterestShows(
        InterestShowPaginationServiceRequest request
    ) {
        var interestShows = userShowUseCase.findInterestShows(request.toDomainRequest());
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

    public void view(UUID showId) {
        showUseCase.view(showId);
    }

    public ShowInterestServiceResponse interest(ShowInterestServiceRequest request) {
        return ShowInterestServiceResponse.from(
            userShowUseCase.interest(request.toDomainRequest())
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

    public void alertReservation(
        TicketingAlertReservationServiceRequest ticketingAlertReservationRequest
    ) {
        ShowTicketingTime showTicketingTime = showUseCase.findTicketingTimeWithShow(
            ticketingAlertReservationRequest.showId(),
            ticketingAlertReservationRequest.type().toDomainType()
        );

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
        List<TicketingAlert> ticketingAlerts = ticketingAlertUseCase.findTicketingAlertsByUserId(request.userId());
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

    public TerminatedTicketingShowCountServiceResponse countTerminatedTicketingShow(UUID userId) {
        List<TicketingAlert> ticketingAlerts = ticketingAlertUseCase.findTicketingAlertsByUserId(userId);
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
