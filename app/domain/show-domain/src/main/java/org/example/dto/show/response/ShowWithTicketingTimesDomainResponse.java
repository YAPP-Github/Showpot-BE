package org.example.dto.show.response;

import java.util.List;

public record ShowWithTicketingTimesDomainResponse(
    ShowDomainResponse show,
    List<ShowTicketingTimeDomainResponse> ticketingTimes
) {

}
