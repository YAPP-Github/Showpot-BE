package org.example.dto.show.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import org.example.entity.show.info.SeatPrices;
import org.example.entity.show.info.TicketingSites;

/**
 * 엔티티 조회 객체
 */
@Builder
public record ShowDomainResponse(
    UUID id,
    String title,
    String content,
    LocalDate startDate,
    LocalDate endDate,
    String location,
    String image,
    LocalDateTime lastTicketingAt,
    int viewCount,
    SeatPrices seatPrices,
    TicketingSites ticketingSites
) {

}
