package org.example.dto.show.param;

import java.util.List;
import org.example.dto.show.response.ShowDomainResponse;
import org.example.dto.show.response.ShowTicketingTimeDomainResponse;

public record ShowWithTicketingTimesDomainParam(
    ShowDomainResponse show,
    List<ShowTicketingTimeDomainResponse> ticketingTimes
) {

}
