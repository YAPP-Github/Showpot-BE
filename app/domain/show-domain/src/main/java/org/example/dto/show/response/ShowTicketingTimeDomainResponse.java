package org.example.dto.show.response;

import java.time.LocalDate;
import org.example.vo.TicketingType;

public record ShowTicketingTimeDomainResponse(
    TicketingType ticketingType,
    LocalDate ticketingAt
) {

}
