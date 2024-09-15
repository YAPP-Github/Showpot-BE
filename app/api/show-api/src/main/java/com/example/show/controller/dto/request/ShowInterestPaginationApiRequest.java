package com.example.show.controller.dto.request;

import com.example.show.service.dto.request.InterestShowPaginationServiceRequest;
import io.swagger.v3.oas.annotations.Parameter;
import java.time.LocalDateTime;
import java.util.UUID;

public record ShowInterestPaginationApiRequest(
    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId,

    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorValue / 최초 조회라면 null")
    LocalDateTime cursorValue
) {

    public InterestShowPaginationServiceRequest toServiceRequest(UUID userId, int size) {
        return InterestShowPaginationServiceRequest.builder()
            .userId(userId)
            .size(size)
            .cursorId(cursorId)
            .cursorValue(cursorValue)
            .build();
    }
}
