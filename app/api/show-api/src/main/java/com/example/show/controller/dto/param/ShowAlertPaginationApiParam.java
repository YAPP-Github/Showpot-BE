package com.example.show.controller.dto.param;

import com.example.show.service.dto.param.ShowAlertPaginationServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.UUID;
import org.example.util.DateTimeUtil;

public record ShowAlertPaginationApiParam(
    @Schema(description = "공연 ID")
    UUID id,

    @Schema(description = "공연 제목")
    String title,

    @Schema(description = "공연 시작 날짜")
    String startAt,

    @Schema(description = "공연 마지막 날짜")
    String endAt,

    @Schema(description = "공연 장소")
    String location,

    @Schema(description = "공연 이미지 URL")
    String imageURL,

    @Schema(description = "cursorID")
    UUID cursorId,

    @Schema(description = "cursorValue")
    LocalDateTime cursorValue
) {

    public static ShowAlertPaginationApiParam from(ShowAlertPaginationServiceParam serviceParam) {
        return new ShowAlertPaginationApiParam(
            serviceParam.id(),
            serviceParam.title(),
            DateTimeUtil.formatDate(serviceParam.startAt()),
            DateTimeUtil.formatDate(serviceParam.endAt()),
            serviceParam.location(),
            serviceParam.image(),
            serviceParam.cursorId(),
            serviceParam.cursorValue()
        );
    }
}
