package com.example.show.service.dto.response;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.show.response.ShowDetailDomainResponse;

@Builder
public record ShowPaginationServiceResponse(
    UUID id,
    String title,
    String location,
    String posterImageURL,
    String reservationDate,
    boolean hasTicketingOpenSchedule,
    List<ShowArtistSimpleServiceResponse> artists,
    List<ShowGenreSimpleServiceResponse> genres,
    List<ShowTicketingTimeServiceParam> showTicketingTimes
) {

    public static ShowPaginationServiceResponse from(ShowDetailDomainResponse response) {
        return ShowPaginationServiceResponse.builder()
            .id(response.show().id())
            .title(response.show().title())
            .location(response.show().location())
            .posterImageURL(response.show().image())
            // TODO: Show에 lastTicketingAt을 업데이트
            // .reservationDate()
            // TODO: Show에 lastTicketingAt을 업데이트
            // .hasTicketingOpenSchedule()
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

            .showTicketingTimes(
                response.showTicketingTimes().stream()
                    .map(ShowTicketingTimeServiceParam::from)
                    .toList()
            )
            .build();
    }
}
