package org.example.repository.show.showticketing;

import java.util.Optional;
import java.util.UUID;
import org.example.dto.show.request.ShowAlertPaginationDomainRequest;
import org.example.dto.show.response.ShowAlertPaginationDomainResponse;
import org.example.entity.show.ShowTicketingTime;
import org.example.vo.TicketingType;

public interface ShowTicketingTimeQuerydslRepository {

    ShowAlertPaginationDomainResponse findShowAlerts(ShowAlertPaginationDomainRequest request);

    Optional<ShowTicketingTime> findByShowIdAndTicketingTypeWithShow(UUID showId, TicketingType type);

}
