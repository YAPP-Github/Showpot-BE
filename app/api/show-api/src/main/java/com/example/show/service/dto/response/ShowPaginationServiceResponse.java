package com.example.show.service.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.show.response.ShowDetailDomainResponse;
import org.example.util.DateTimeUtil;

@Builder
public record ShowPaginationServiceResponse(
    UUID id,
    String title,
    String location,
    String posterImageURL,
    String reservationAt,
    boolean hasTicketingOpenSchedule,
    List<ShowArtistSimpleServiceResponse> artists,
    List<ShowGenreSimpleServiceResponse> genres,
    List<ShowTicketingTimeServiceParam> showTicketingTimes
) {

    public static ShowPaginationServiceResponse from(ShowDetailDomainResponse response, LocalDateTime now) {
        List<ShowTicketingTimeServiceParam> ticketingTimes = response.showTicketingTimes().stream()
            .map(ShowTicketingTimeServiceParam::from)
            .toList();

        Optional<ShowTicketingTimeServiceParam> optShowTicketingTime = ticketingTimes.stream()
            .filter(ticketingTime -> now.isBefore(ticketingTime.ticketingAt()))
            .findFirst();

        String reservationAt = optShowTicketingTime.map(
            showTicketingTime -> DateTimeUtil.formatLocalDateTime(showTicketingTime.ticketingAt())
        ).orElseGet(() -> "");

        return ShowPaginationServiceResponse.builder()
            .id(response.show().id())
            .title(response.show().title())
            .location(response.show().location())
            .posterImageURL(response.show().image())
            .reservationAt(reservationAt)
            .hasTicketingOpenSchedule(now.isBefore(response.show().lastTicketingAt()))
            .artists(
                response.artists().stream()
                    .map(ShowArtistSimpleServiceResponse::from)
                    .toList()
            )
            .genres(
                response.genres().stream()
                    .map(ShowGenreSimpleServiceResponse::from)
                    .toList()
            )
            .showTicketingTimes(ticketingTimes)
            .build();
    }
}
