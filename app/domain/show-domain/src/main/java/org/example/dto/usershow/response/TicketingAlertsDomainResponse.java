package org.example.dto.usershow.response;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record TicketingAlertsDomainResponse(
    String name,
    UUID showId,
    List<TicketingTimeDomainResponse> addAts,
    List<TicketingTimeDomainResponse> deleteAts
) {

}
