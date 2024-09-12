package com.example.show.controller.dto.param;

import com.example.show.service.dto.param.ShowSearchPaginationServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import org.example.dto.response.CursorApiResponse;
import org.example.util.DateTimeUtil;

public record ShowSearchPaginationApiParam(
    @Schema(description = "공연 Cursor")
    CursorApiResponse cursor,

    @Schema(description = "공연 제목")
    String title,

    @Schema(description = "공연 시작 날짜")
    String startAt,

    @Schema(description = "공연 마지막 날짜")
    String endAt,

    @Schema(description = "공연 장소")
    String location,

    @Schema(description = "공연 이미지")
    String imageURL
) {

    public static ShowSearchPaginationApiParam from(ShowSearchPaginationServiceParam serviceParam) {
        return new ShowSearchPaginationApiParam(
            CursorApiResponse.toCursorId(serviceParam.id()),
            serviceParam.title(),
            DateTimeUtil.formatDate(serviceParam.startAt()),
            DateTimeUtil.formatDate(serviceParam.endAt()),
            serviceParam.location(),
            serviceParam.image()
        );
    }
}
