package com.example.show.controller.dto.request;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import org.example.pagination.vo.SortDirection;

public record ShowInterestPaginationApiRequest(

    @Schema(description = "정렬 방향")
    SortDirection sortDirection,

    @Parameter(description = "이전 페이지네이션 마지막 데이터의 ID / 최초 조회라면 null")
    UUID cursor
) {

}
