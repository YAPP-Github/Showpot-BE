package org.example.dto.show.request;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.entity.show.Show;
import org.example.entity.show.info.SeatPrices;
import org.example.entity.show.info.ShowTicketingTimes;
import org.example.entity.show.info.TicketingSites;

@Builder
public record ShowUpdateDomainRequest(
    String title,
    String content,
    LocalDate startDate,
    LocalDate endDate,
    String location,
    String posterImageURL,
    SeatPrices showSeats,
    TicketingSites showTicketingSites,
    ShowTicketingTimes showTicketingTimes,
    List<UUID> artistIds,
    List<UUID> genreIds
) {

    public Show toShow() {
        return Show.builder()
            .title(title)
            .content(content)
            .startDate(startDate)
            .endDate(endDate)
            .location(location)
            .image(posterImageURL)
            .seatPrices(showSeats)
            .ticketingSites(showTicketingSites)
            .build();
    }
}
