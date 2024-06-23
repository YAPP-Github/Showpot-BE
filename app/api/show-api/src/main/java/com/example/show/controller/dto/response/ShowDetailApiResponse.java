package com.example.show.controller.dto.response;

import com.example.artist.controller.dto.response.ArtistSimpleApiResponse;
import com.example.genre.controller.dto.response.GenreSimpleApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;

public record ShowDetailApiResponse(

    @Schema(description = "공연 ID")
    UUID id,

    @Schema(description = "공연 이름")
    String name,

    @Schema(description = "아티스트 정보")
    ArtistSimpleApiResponse artist,

    @Schema(description = "장르 정보")
    GenreSimpleApiResponse genre,

    @Schema(description = "티켓팅 정보 및 공연 날짜")
    List<TicketingAndShowInfoApiResponse> ticketingAndShowInfo,

    @Schema(description = "공연 포스터 주소")
    String posterImageURL
) {

}
