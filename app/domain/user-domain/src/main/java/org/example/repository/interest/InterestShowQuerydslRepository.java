package org.example.repository.interest;

import java.time.LocalDateTime;
import java.util.UUID;
import org.example.dto.request.InterestShowPaginationDomainRequest;
import org.example.dto.response.InterestShowPaginationDomainResponse;

public interface InterestShowQuerydslRepository {

    InterestShowPaginationDomainResponse findInterestShowList(InterestShowPaginationDomainRequest request);

    long countValidTicketingAlerts(UUID userId, LocalDateTime now);
}
