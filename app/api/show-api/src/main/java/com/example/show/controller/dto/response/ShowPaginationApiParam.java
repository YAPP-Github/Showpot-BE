package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.ShowPaginationServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowPaginationApiParam(

    @Schema(description = "공연 ID")
    UUID id,

    @Schema(description = "공연 이름")
    String title,

    @Schema(description = "공연 장소")
    String location,

    @Schema(description = "공연 포스터 이미지 주소")
    String posterImageURL,

    @Schema(description = "가장 근접한 예매 시간")
    String reservationAt,

    @Schema(description = "오픈 예정인 티켓팅 일정이 있는지 여부")
    boolean hasTicketingOpenSchedule,

    @Schema(description = "아티스트 정보")
    List<ShowArtistPaginationApiParam> artists,

    @Schema(description = "장르 정보")
    List<ShowGenrePaginationApiParam> genres,

    @Schema(description = "예약 시간 정보")
    List<ShowTicketingTimePaginationApiParam> showTicketingTimes
) {

    public static ShowPaginationApiParam from(ShowPaginationServiceResponse response) {
        return ShowPaginationApiParam.builder()
            .id(response.id())
            .title(response.title())
            .location(response.location())
            .posterImageURL(response.posterImageURL())
            .reservationAt(response.reservationAt())
            .hasTicketingOpenSchedule(response.hasTicketingOpenSchedule())
            .artists(
                response.artists().stream()
                    .map(ShowArtistPaginationApiParam::from)
                    .toList()
            )
            .genres(
                response.genres().stream()
                    .map(ShowGenrePaginationApiParam::from)
                    .toList()
            )
            .showTicketingTimes(
                response.showTicketingTimes().stream()
                    .map(ShowTicketingTimePaginationApiParam::from)
                    .toList()
            )
            .build();
    }
}
