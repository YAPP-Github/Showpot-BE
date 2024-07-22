package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.ShowSearchServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.util.UUID;

public record ShowSearchApiResponse(
    @Schema(description = "공연 ID")
    UUID id,

    @Schema(description = "공연 제목")
    String title,

    @Schema(description = "공연 날짜")
    LocalDate date,

    @Schema(description = "공연 장소")
    String location,

    @Schema(description = "공연 이미지")
    String image
) {

    public ShowSearchApiResponse(ShowSearchServiceResponse showSearchServiceResponse) {
        this(
            showSearchServiceResponse.id(),
            showSearchServiceResponse.title(),
            showSearchServiceResponse.date(),
            showSearchServiceResponse.location(),
            showSearchServiceResponse.image()
        );
    }
}
