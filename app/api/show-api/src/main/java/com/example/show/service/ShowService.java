package com.example.show.service;

import com.example.show.controller.vo.TicketingApiType;
import com.example.show.error.ShowError;
import com.example.show.service.dto.param.ShowSearchPaginationServiceParam;
import com.example.show.service.dto.request.ShowPaginationServiceRequest;
import com.example.show.service.dto.request.ShowSearchPaginationServiceRequest;
import com.example.show.service.dto.response.ShowDetailServiceResponse;
import com.example.show.service.dto.response.ShowPaginationServiceResponse;
import com.example.show.service.dto.response.TicketingAlertReservationAvailabilityServiceResponse;
import com.example.show.service.dto.response.TicketingAlertReservationServiceResponse;
import com.example.show.service.dto.response.TicketingAlertReservationStatusServiceResponse;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.PaginationServiceResponse;
import org.example.dto.show.response.ShowDetailDomainResponse;
import org.example.entity.TicketingAlert;
import org.example.exception.BusinessException;
import org.example.usecase.TicketingAlertUseCase;
import org.example.usecase.show.ShowUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowUseCase showUseCase;
    private final TicketingAlertUseCase ticketingAlertUseCase;

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
            .map(ShowSearchPaginationServiceParam::new)
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

    public void view(UUID showId) {
        showUseCase.view(showId);
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
}
