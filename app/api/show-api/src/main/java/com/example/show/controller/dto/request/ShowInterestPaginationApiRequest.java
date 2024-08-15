package com.example.show.controller.dto.request;

import com.example.show.service.dto.request.InterestShowPaginationServiceRequest;
import io.swagger.v3.oas.annotations.Parameter;
import java.util.UUID;

public record ShowInterestPaginationApiRequest(

    @Parameter(description = "페이지네이션 데이터 개수")
    int size,
    @Parameter(description = "이전 페이지네이션 마지막 데이터의 ID / 최초 조회라면 null")
    UUID cursorId
) {

    public InterestShowPaginationServiceRequest toServiceRequest(UUID userId) {
        return InterestShowPaginationServiceRequest.builder()
            .userId(userId)
            .size(size)
            .cursorId(cursorId)
            .build();
    }
}
