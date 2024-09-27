package com.example.show.controller.dto.response;

import com.example.show.controller.dto.param.SeatTypePriceApiParam;
import com.example.show.controller.dto.param.ShowArtistApiParam;
import com.example.show.controller.dto.param.ShowGenreApiParam;
import com.example.show.controller.dto.param.ShowTicketingTimeApiParam;
import com.example.show.controller.dto.param.TicketingSiteApiParam;
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

    @Schema(description = "공연 시작일")
    String startDate,

    @Schema(description = "공연 종료일")
    String endDate,

    @Schema(description = "공연 장소")
    String location,

    @Schema(description = "공연 포스터 주소")
    String posterImageURL,

    @Schema(description = "공연 포스터 주소")
    boolean isInterested,

    @Schema(description = "아티스트 정보")
    List<ShowArtistApiParam> artists,

    @Schema(description = "장르 정보")
    List<ShowGenreApiParam> genres,

    @Schema(description = "티켓팅 예매 시간 정보")
    List<ShowTicketingTimeApiParam> ticketingTimes,

    @Schema(description = "좌석별 가격 정보")
    List<SeatTypePriceApiParam> seats,

    @Schema(description = "티켓팅 사이트별 링크")
    List<TicketingSiteApiParam> ticketingSites
) {

    public static ShowDetailApiResponse from(ShowDetailServiceResponse show) {
        return ShowDetailApiResponse.builder()
            .id(show.id())
            .name(show.title())
            .startDate(DateTimeUtil.formatDate(show.startDate()))
            .endDate(DateTimeUtil.formatDate(show.endDate()))
            .location(show.location())
            .posterImageURL(show.posterImageURL())
            .isInterested(show.isInterested())
            .artists(
                show.artists().stream()
                    .map(ShowArtistApiParam::from)
                    .toList()
            )
            .genres(
                show.genres().stream()
                    .map(ShowGenreApiParam::from)
                    .toList()
            )
            .ticketingTimes(
                show.ticketingTimes().stream()
                    .map(ShowTicketingTimeApiParam::from)
                    .toList()
            )
            .seats(
                show.seats().priceBySeat().entrySet().stream()
                .map(entry -> SeatTypePriceApiParam.of(entry.getKey(), entry.getValue()))
                .toList()
            )
            .ticketingSites(
                show.ticketingSites().siteByURL().entrySet().stream()
                .map(entry -> TicketingSiteApiParam.of(entry.getKey(), entry.getValue()))
                .toList()
            )
            .build();
    }
}
