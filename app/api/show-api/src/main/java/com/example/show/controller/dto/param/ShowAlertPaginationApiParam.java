package com.example.show.controller.dto.param;

import com.example.show.service.dto.param.ShowAlertPaginationServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.util.UUID;

public record ShowAlertPaginationApiParam(
    @Schema(description = "공연 ID")
    UUID id,

    @Schema(description = "공연 제목")
    String title,

    @Schema(description = "공연 시작 날짜")
    LocalDate startDate,

    @Schema(description = "공연 마지막 날짜")
    LocalDate endDate,

    @Schema(description = "공연 장소")
    String location,

    @Schema(description = "공연 이미지")
    String image
) {

    public static ShowAlertPaginationApiParam from(ShowAlertPaginationServiceParam serviceParam) {
        return new ShowAlertPaginationApiParam(
            serviceParam.id(),
            serviceParam.title(),
            serviceParam.startDate(),
            serviceParam.endDate(),
            serviceParam.location(),
            serviceParam.image()
        );
    }
}
