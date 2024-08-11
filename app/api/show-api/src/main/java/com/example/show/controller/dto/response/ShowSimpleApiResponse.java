package com.example.show.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowSimpleApiResponse(

    @Schema(description = "공연 ID")
    UUID id,

    @Schema(description = "공연 이름")
    String title,

    @Schema(description = "공연 장소")
    String location,

    @Schema(description = "아티스트 정보")
    ShowArtistSimpleApiResponse artist,

    @Schema(description = "장르 정보")
    ShowGenreSimpleApiResponse genre,

    @Schema(description = "공연 포스터 이미지 주소")
    String posterImageURL,

    @Schema(description = "예매일")
    String reservationDate,

    @Schema(description = "오픈 예정인 티켓팅 일정이 있는지 여부")
    boolean hasTicketingOpenSchedule
) {

}
