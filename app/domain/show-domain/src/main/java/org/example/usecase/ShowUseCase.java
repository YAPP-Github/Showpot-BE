package org.example.usecase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.show.request.ShowAlertPaginationDomainRequest;
import org.example.dto.show.request.ShowPaginationDomainRequest;
import org.example.dto.show.request.ShowSearchPaginationDomainRequest;
import org.example.dto.show.response.ShowAlertPaginationDomainResponse;
import org.example.dto.show.response.ShowDetailDomainResponse;
import org.example.dto.show.response.ShowSearchPaginationDomainResponse;
import org.example.dto.show.response.ShowTicketingPaginationDomainResponse;
import org.example.entity.show.Show;
import org.example.entity.show.ShowTicketingTime;
import org.example.repository.show.ShowRepository;
import org.example.repository.show.showsearch.ShowSearchRepository;
import org.example.repository.show.showticketing.ShowTicketingTimeRepository;
import org.example.vo.TicketingType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ShowUseCase {

    private final ShowRepository showRepository;
    private final ShowSearchRepository showSearchRepository;
    private final ShowTicketingTimeRepository showTicketingTimeRepository;

    public ShowDetailDomainResponse findShowDetail(UUID id) {
        return showRepository.findShowDetailById(id).orElseThrow(NoSuchElementException::new);
    }

    public ShowTicketingPaginationDomainResponse findShows(ShowPaginationDomainRequest request) {
        return showRepository.findShows(request);
    }

    public List<Show> findShowsInIds(List<UUID> showIds) {
        return showRepository.findShowsByIdInAndIsDeletedFalse(showIds);
    }

    @Transactional
    public void view(UUID id) {
        findShowOrThrowNoSuchElementException(id).view();
    }

    public ShowSearchPaginationDomainResponse searchShow(
        ShowSearchPaginationDomainRequest request
    ) {
        return showSearchRepository.searchShow(request);
    }

    public ShowAlertPaginationDomainResponse findAlertShows(
        ShowAlertPaginationDomainRequest request
    ) {
        return showTicketingTimeRepository.findShowAlerts(request);
    }

    public ShowTicketingTime findTicketingAlertReservation(
        UUID showId,
        TicketingType type
    ) {
        return showTicketingTimeRepository.findByShowIdAndTicketingTypeAndIsDeletedFalse(showId, type)
            .orElseThrow(NoSuchElementException::new);
    }

    public ShowTicketingTime findTicketingTimeWithShow(
        UUID showId,
        TicketingType type
    ) {
        return showTicketingTimeRepository.findByShowIdAndTicketingTypeWithShow(showId, type)
            .orElseThrow(NoSuchElementException::new);
    }

    public long findTerminatedTicketingShowsCount(List<UUID> showIds, LocalDateTime now) {
        return showRepository.findTerminatedTicketingShowsCount(showIds, now);
    }

    public Show findShowOrThrowNoSuchElementException(UUID id) {
        return showRepository.findByIdAndIsDeletedFalse(id).orElseThrow(NoSuchElementException::new);
    }
}
