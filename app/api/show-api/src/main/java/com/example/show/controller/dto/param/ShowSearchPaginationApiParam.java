package com.example.show.controller.dto.param;

import com.example.show.service.dto.param.ShowSearchPaginationServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.util.UUID;

public record ShowSearchPaginationApiParam(
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

    public static ShowSearchPaginationApiParam from(ShowSearchPaginationServiceParam serviceParam) {
        return new ShowSearchPaginationApiParam(
            serviceParam.id(),
            serviceParam.title(),
            serviceParam.date(),
            serviceParam.location(),
            serviceParam.image()
        );
    }
}
