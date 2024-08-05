package org.example.dto.show.response;

import java.time.LocalDateTime;
import org.example.vo.TicketingType;

public record ShowTicketingTimeDomainResponse(
    TicketingType ticketingType,
    LocalDateTime ticketingAt
) {

}
