package org.example.dto.response;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record TicketingAlertsDomainResponse(

    String userFcmToken,
    String name,
    UUID showId,
    List<TicketingTimeDomainResponse> addAts,
    List<TicketingTimeDomainResponse> deleteAts
) {

}
