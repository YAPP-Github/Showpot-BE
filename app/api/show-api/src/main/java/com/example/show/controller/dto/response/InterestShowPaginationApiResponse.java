package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.InterestShowPaginationServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.response.CursorApiResponse;
import org.example.util.DateTimeUtil;

@Builder
public record InterestShowPaginationApiResponse(
    @Schema(description = "공연 ID")
    UUID id,

    @Schema(description = "공연 이름")
    String title,

    @Schema(description = "공연 시작 날짜")
    String startAt,

    @Schema(description = "공연 종료 날짜")
    String endAt,

    @Schema(description = "공연 장소")
    String location,

    @Schema(description = "공연 포스터 이미지 주소")
    String posterImageURL,

    @Schema(description = "조회한 데이터의 Cursor")
    CursorApiResponse cursor
) {

    public static InterestShowPaginationApiResponse from(
        InterestShowPaginationServiceResponse response
    ) {
        return InterestShowPaginationApiResponse.builder()
            .id(response.showId())
            .title(response.title())
            .startAt(DateTimeUtil.formatDate(response.startAt()))
            .endAt(DateTimeUtil.formatDate(response.endAt()))
            .location(response.location())
            .posterImageURL(response.posterImageURL())
            .cursor(CursorApiResponse.toCursor(response.interestShowId(), response.interestedAt()))
            .build();
    }
}
