package org.example.repository.show.showticketing;

import org.example.dto.show.request.ShowAlertPaginationDomainRequest;
import org.example.dto.show.response.ShowAlertPaginationDomainResponse;

public interface ShowTicketingTimeQuerydslRepository {

    ShowAlertPaginationDomainResponse findShowAlerts(ShowAlertPaginationDomainRequest request);

}
