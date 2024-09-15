package com.example.show.controller.dto.request;

import com.example.show.service.dto.request.ShowSearchPaginationServiceRequest;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Max;
import java.util.UUID;

public record ShowSearchPaginationApiRequest(
    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId,

    @Parameter(description = "검색어", required = true)
    String search,

    @Parameter(example = "30")
    @Max(value = 30, message = "조회하는 데이터의 최대 개수는 30입니다.")
    Integer size
) {
    public ShowSearchPaginationApiRequest {
        if (size == null) {
            size = 30;
        }
    }

    public ShowSearchPaginationServiceRequest toServiceRequest(int size) {
        return ShowSearchPaginationServiceRequest.builder()
            .cursor(cursorId)
            .size(size)
            .search(search)
            .build();
    }
}
