package com.example.show.controller.dto.request;

import com.example.show.service.dto.request.ShowSearchPaginationServiceRequest;
import io.swagger.v3.oas.annotations.Parameter;
import java.util.UUID;

public record ShowSearchPaginationApiRequest(
    @Parameter(description = "이전 페이지네이션 마지막 데이터의 ID / 최초 조회라면 null")
    UUID cursor,

    @Parameter(description = "조회하는 데이터 개수")
    int size,

    @Parameter(description = "검색어")
    String search
) {

    public ShowSearchPaginationServiceRequest toServiceRequest() {
        return ShowSearchPaginationServiceRequest.builder()
            .cursor(cursor)
            .size(size)
            .search(search)
            .build();
    }
}
