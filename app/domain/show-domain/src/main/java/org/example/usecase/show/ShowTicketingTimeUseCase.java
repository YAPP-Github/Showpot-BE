package org.example.usecase.show;

import lombok.RequiredArgsConstructor;
import org.example.dto.show.request.ShowAlertPaginationDomainRequest;
import org.example.dto.show.response.ShowAlertPaginationDomainResponse;
import org.example.repository.show.showticketing.ShowTicketingTimeRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShowTicketingTimeUseCase {

    private final ShowTicketingTimeRepository showTicketingTimeRepository;

    public ShowAlertPaginationDomainResponse findAlertShows(ShowAlertPaginationDomainRequest request) {
        return showTicketingTimeRepository.findShowAlerts(request);
    }
}
