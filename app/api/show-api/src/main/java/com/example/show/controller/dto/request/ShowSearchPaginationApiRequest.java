package com.example.show.controller.dto.request;

import com.example.show.service.dto.request.ShowSearchPaginationServiceRequest;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Max;
import java.util.UUID;
import org.example.util.ValidatorCursorSize;

public record ShowSearchPaginationApiRequest(
    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId,

    @Parameter(description = "조회하는 데이터 개수", required = true)
    @Max(value = 30, message = "조회하는 데이터 개수는 최대 30개 이어야 합니다.")
    Integer size,

    @Parameter(description = "검색어", required = true)
    String search
) {

    public ShowSearchPaginationServiceRequest toServiceRequest() {
        return ShowSearchPaginationServiceRequest.builder()
            .cursor(cursorId)
            .size(ValidatorCursorSize.getDefaultSize(size))
            .search(search)
            .build();
    }
}
