package org.example.dto.show.response;

import java.time.LocalDate;
import java.util.UUID;
import org.example.entity.show.info.SeatPrices;
import org.example.entity.show.info.TicketingSites;

/**
 * 엔티티 조회 객체
 */
public record ShowDomainResponse(
    UUID id,
    String title,
    String content,
    LocalDate startDate,
    LocalDate endDate,
    String location,
    String image,
    SeatPrices seatPrices,
    TicketingSites ticketingSites
) {

}
