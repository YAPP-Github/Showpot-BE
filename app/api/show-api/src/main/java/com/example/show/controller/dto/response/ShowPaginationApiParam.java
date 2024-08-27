package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.ShowPaginationServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import lombok.Builder;
import org.example.util.DateTimeUtil;

@Builder
public record ShowPaginationApiParam(

    @Schema(description = "공연 ID")
    UUID id,

    @Schema(description = "공연 이름")
    String title,

    @Schema(description = "공연 장소")
    String location,

    @Schema(description = "공연 포스터 이미지 주소")
    String posterImageURL,

    @Schema(description = "가장 근접한 예매 시간")
    String ticketingAt,

    @Schema(description = "오픈예정 여부")
    boolean onlyOpenSchedule
) {

    public static ShowPaginationApiParam from(ShowPaginationServiceResponse response) {
        return ShowPaginationApiParam.builder()
            .id(response.id())
            .title(response.title())
            .location(response.location())
            .posterImageURL(response.image())
            .ticketingAt(DateTimeUtil.formatDateTime(response.ticketingAt()))
            .onlyOpenSchedule(response.onlyOpenSchedule())
            .build();
    }
}
