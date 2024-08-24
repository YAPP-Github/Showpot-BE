package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.ShowDetailServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.util.DateTimeUtil;

@Builder
public record ShowDetailApiResponse(

    @Schema(description = "공연 ID")
    UUID id,

    @Schema(description = "공연 이름")
    String name,

    @Schema(description = "공연 내용")
    String content,

    @Schema(description = "공연 시작일")
    String startDate,

    @Schema(description = "공연 종료일")
    String endDate,

    @Schema(description = "공연 장소")
    String location,

    @Schema(description = "공연 포스터 주소")
    String posterImageURL,

    @Schema(description = "아티스트 정보")
    List<ShowArtistApiResponse> artists,

    @Schema(description = "장르 정보")
    List<ShowGenreApiResponse> genres,

    @Schema(description = "티켓팅 예매 시간 정보")
    List<ShowTicketingTimeApiResponse> ticketingTimes,

    @Schema(description = "좌석별 가격 정보")
    List<SeatTypePriceApiResponse> seats,

    @Schema(description = "티켓팅 사이트별 링크")
    List<TicketingSiteApiResponse> ticketingSites
) {

    public static ShowDetailApiResponse from(ShowDetailServiceResponse show) {
        return ShowDetailApiResponse.builder()
            .id(show.id())
            .name(show.title())
            .content(show.content())
            .startDate(DateTimeUtil.formatDate(show.startDate()))
            .endDate(DateTimeUtil.formatDate(show.endDate()))
            .location(show.location())
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
            .ticketingTimes(
                show.ticketingTimes().stream()
                    .map(ShowTicketingTimeApiResponse::from)
                    .toList()
            )
            .seats(
                show.seats().priceBySeat().entrySet().stream()
                .map(entry -> SeatTypePriceApiResponse.of(entry.getKey(), entry.getValue()))
                .toList()
            )
            .ticketingSites(
                show.ticketingSites().siteByURL().entrySet().stream()
                .map(entry -> TicketingSiteApiResponse.of(entry.getKey(), entry.getValue()))
                .toList()
            )
            .build();
    }
}
