package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.InterestShowPaginationServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import org.example.util.DateTimeUtil;

@Builder
public record InterestShowPaginationApiResponse(
    @Schema(description = "공연 ID")
    UUID id,

    @Schema(description = "cursorID로서 관심 공연 ID")
    UUID interestShowId,

    @Schema(description = "cursorValue로서 관심 공연 지정 시간")
    LocalDateTime interestedAt,

    @Schema(description = "공연 이름")
    String title,

    @Schema(description = "공연 시작 날짜")
    String startAt,

    @Schema(description = "공연 종료 날짜")
    String endAt,

    @Schema(description = "공연 장소")
    String location,

    @Schema(description = "공연 포스터 이미지 주소")
    String posterImageURL
) {

    public static InterestShowPaginationApiResponse from(
        InterestShowPaginationServiceResponse response
    ) {
        return InterestShowPaginationApiResponse.builder()
            .id(response.showId())
            .interestShowId(response.interestShowId())
            .interestedAt(response.interestedAt())
            .title(response.title())
            .startAt(DateTimeUtil.formatDate(response.startAt()))
            .endAt(DateTimeUtil.formatDate(response.endAt()))
            .location(response.location())
            .posterImageURL(response.posterImageURL())
            .build();
    }
}
