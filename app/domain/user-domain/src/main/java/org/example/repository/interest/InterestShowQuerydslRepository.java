package org.example.repository.interest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.example.dto.request.InterestShowPaginationDomainRequest;
import org.example.dto.response.InterestShowPaginationDomainResponse;
import org.example.entity.TicketingAlert;

public interface InterestShowQuerydslRepository {

    InterestShowPaginationDomainResponse findInterestShowList(InterestShowPaginationDomainRequest request);

    List<TicketingAlert> findValidTicketingAlerts(UUID userId, LocalDateTime now);
}
