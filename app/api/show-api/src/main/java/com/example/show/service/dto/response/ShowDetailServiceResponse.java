package com.example.show.service.dto.response;

import com.example.show.service.dto.param.ShowArtistServiceParam;
import com.example.show.service.dto.param.ShowGenreServiceParam;
import com.example.show.service.dto.param.ShowTicketingTimeServiceParam;
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
    boolean isInterested,
    List<ShowArtistServiceParam> artists,
    List<ShowGenreServiceParam> genres,
    List<ShowTicketingTimeServiceParam> ticketingTimes,
    ShowSeatServiceResponse seats,
    ShowTicketingSiteServiceResponse ticketingSites
) {

    public static ShowDetailServiceResponse from(
        ShowDetailDomainResponse show,
        boolean isInterested
    ) {
        return ShowDetailServiceResponse.builder()
            .id(show.show().id())
            .title(show.show().title())
            .content(show.show().content())
            .startDate(show.show().startDate())
            .endDate(show.show().endDate())
            .location(show.show().location())
            .posterImageURL(show.show().image())
            .isInterested(isInterested)
            .artists(
                show.artists().stream()
                    .map(ShowArtistServiceParam::from)
                    .toList()
            )
            .genres(
                show.genres().stream()
                    .map(ShowGenreServiceParam::from)
                    .toList()
            )
            .ticketingTimes(show.showTicketingTimes().stream()
                .map(ShowTicketingTimeServiceParam::from)
                .toList()
            )
            .seats(ShowSeatServiceResponse.from(show.show().seatPrices()))
            .ticketingSites(ShowTicketingSiteServiceResponse.from(show.show().ticketingSites()))
            .build();
    }
}
