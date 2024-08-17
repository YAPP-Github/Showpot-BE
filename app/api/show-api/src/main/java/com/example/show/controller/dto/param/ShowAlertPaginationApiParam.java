package com.example.show.controller.dto.param;

import com.example.show.service.dto.param.ShowAlertPaginationServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record ShowAlertPaginationApiParam(
    @Schema(description = "공연 ID")
    UUID id,

    @Schema(description = "공연 제목")
    String title,

    @Schema(description = "공연 시작 날짜")
    LocalDate startAt,

    @Schema(description = "공연 마지막 날짜")
    LocalDate endAt,

    @Schema(description = "공연 장소")
    String location,

    @Schema(description = "공연 이미지")
    String image,

    @Schema(description = "공연 티켓팅 날짜")
    LocalDateTime ticketingAt
) {

    public static ShowAlertPaginationApiParam from(ShowAlertPaginationServiceParam serviceParam) {
        return new ShowAlertPaginationApiParam(
            serviceParam.id(),
            serviceParam.title(),
            serviceParam.startAt(),
            serviceParam.endAt(),
            serviceParam.location(),
            serviceParam.image(),
            serviceParam.ticketingAt()
        );
    }
}
