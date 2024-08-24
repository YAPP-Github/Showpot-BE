package com.example.show.service.dto.response;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.show.response.ShowDetailDomainResponse;

@Builder
public record ShowDetailServiceResponse(

    UUID id,
    String title,
    String content,
    LocalDate startDate,
    LocalDate endDate,
    String location,
    String posterImageURL,
    List<ShowArtistServiceResponse> artists,
    List<ShowGenreServiceResponse> genres,
    List<ShowTicketingTimeServiceResponse> ticketingTimes,
    ShowSeatServiceResponse seats,
    ShowTicketingSiteServiceResponse ticketingSites
) {

    public static ShowDetailServiceResponse from(ShowDetailDomainResponse show) {
        return ShowDetailServiceResponse.builder()
            .id(show.show().id())
            .title(show.show().title())
            .content(show.show().content())
            .startDate(show.show().startDate())
            .endDate(show.show().endDate())
            .location(show.show().location())
            .posterImageURL(show.show().image())
            .artists(
                show.artists().stream()
                    .map(ShowArtistServiceResponse::from)
                    .toList()
            )
            .genres(
                show.genres().stream()
                    .map(ShowGenreServiceResponse::from)
                    .toList()
            )
            .ticketingTimes(show.showTicketingTimes().stream()
                .map(ShowTicketingTimeServiceResponse::from)
                .toList()
            )
            .seats(ShowSeatServiceResponse.from(show.show().seatPrices()))
            .ticketingSites(ShowTicketingSiteServiceResponse.from(show.show().ticketingSites()))
            .build();
    }
}
