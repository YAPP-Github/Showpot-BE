package com.example.show.controller.dto.request;

import com.example.show.service.dto.request.ShowAlertPaginationServiceRequest;
import io.swagger.v3.oas.annotations.Parameter;
import java.util.UUID;

public record ShowAlertPaginationApiRequest(

    @Parameter(description = "페이지네이션 데이터 개수", required = true)
    int size,
    @Parameter(description = "이전 페이지네이션 마지막 데이터의 ID / 최초 조회라면 null")
    UUID cursorId
) {

    public ShowAlertPaginationServiceRequest toServiceRequest(UUID userId) {
        return ShowAlertPaginationServiceRequest.builder()
            .userId(userId)
            .size(size)
            .cursorId(cursorId)
            .build();
    }
}
