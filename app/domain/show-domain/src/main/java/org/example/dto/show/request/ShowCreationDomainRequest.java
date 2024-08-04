package org.example.dto.show.request;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.Builder;
import org.example.entity.show.Show;
import org.example.entity.show.ShowArtist;
import org.example.entity.show.ShowGenre;
import org.example.entity.show.ShowSearch;
import org.example.entity.show.ShowTicketingTime;
import org.example.entity.show.info.SeatPrices;
import org.example.entity.show.info.TicketingSites;
import org.example.vo.TicketingType;

@Builder
public record ShowCreationDomainRequest(
    String title,
    String content,
    LocalDate startDate,
    LocalDate endDate,
    String location,
    String posterImageURL,
    SeatPrices showSeats,
    TicketingSites showTicketingSites,
    //TODO
    Map<TicketingType, LocalDate> showTicketingDates,
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

    public ShowSearch toShowSearch(Show show) {
        return ShowSearch.builder()
            .name(title)
            .show(show)
            .build();
    }

    public List<ShowArtist> toShowArtist(Show show) {
        return artistIds.stream()
            .map(artistId -> ShowArtist.builder()
                .artistId(artistId)
                .showId(show.getId())
                .build()
            )
            .toList();
    }

    public List<ShowGenre> toShowGenre(Show show) {
        return genreIds.stream()
            .map(genreId -> ShowGenre.builder()
                .genreId(genreId)
                .showId(show.getId())
                .build()
            )
            .toList();
    }

    public List<ShowTicketingTime> toShowTicketing(Show show) {
        return showTicketingDates.entrySet().stream()
            .map(entry -> ShowTicketingTime.builder()
                .ticketingType(entry.getKey())
                .ticketingAt(entry.getValue())
                .show(show)
                .build()
            )
            .toList();
    }
}
