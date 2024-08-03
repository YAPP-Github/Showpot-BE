package com.example.show.controller.dto.response;

import com.example.show.controller.dto.param.ShowTicketingSiteApiParam;
import com.example.show.service.dto.response.ShowDetailServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowDetailApiResponse(

    @Schema(description = "공연 ID")
    UUID id,

    @Schema(description = "공연 이름")
    String name,

    @Schema(description = "공연 시작일")
    String startDate,

    @Schema(description = "공연 종료일")
    String endDate,

    @Schema(description = "공연 포스터 주소")
    String posterImageURL,

    @Schema(description = "아티스트 정보")
    List<ShowArtistApiResponse> artists,

    @Schema(description = "장르 정보")
    List<ShowGenreApiResponse> genres,

    @Schema(description = "좌석 정보")
    ShowSeatApiResponse seats,

    @Schema(description = "티켓팅 정보 및 공연 날짜")
    List<ShowTicketingSiteApiParam> ticketingSites
) {

    public static ShowDetailApiResponse from(ShowDetailServiceResponse show) {
        return ShowDetailApiResponse.builder()
            .id(show.id())
            .name(show.title())
            .startDate(show.startDate().toString())
            .endDate(show.endDate().toString())
            .posterImageURL(show.posterImageURL())
            .artists(
                show.artists().stream()
                    .map(ShowArtistApiResponse::from)
                    .toList()
            )
            .genres(
                show.genres().stream()
                    .map(ShowGenreApiResponse::from)
                    .toList()
            )
            .seats(ShowSeatApiResponse.from((show.seats())))
            .ticketingSites(
                show.ticketingSites().stream()
                    .map(ShowTicketingSiteApiParam::from)
                    .toList()
            )
            .build();
    }
}
