package com.example.show.service.dto.response;

import com.example.show.service.dto.param.ShowTicketingSiteServiceParam;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.show.response.ShowDetailDomainResponse;
import org.example.entity.show.info.TicketingSites;

@Builder
public record ShowDetailServiceResponse(

    UUID id,
    String title,
    LocalDate startDate,
    LocalDate endDate,
    String posterImageURL,
    List<ShowArtistServiceResponse> artists,
    List<ShowGenreServiceResponse> genres,
    ShowSeatServiceResponse seats,
    List<ShowTicketingSiteServiceParam> ticketingSites
) {

    public static ShowDetailServiceResponse from(ShowDetailDomainResponse show) {
        TicketingSites ticketingSites = show.show().ticketingSites();
        return ShowDetailServiceResponse.builder()
            .id(show.show().id())
            .title(show.show().title())
            .startDate(show.show().startDate())
            .endDate(show.show().endDate())
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
            .seats(ShowSeatServiceResponse.from(show.show().seatPrices()))
            .ticketingSites(
                ticketingSites.getSites().stream()
                    .map(site -> ShowTicketingSiteServiceParam.builder()
                        .siteName(site)
                        .siteURL(ticketingSites.getURLOrNullBy(site))
                        .build()
                    )
                    .toList()
            )
            .build();
    }
}
