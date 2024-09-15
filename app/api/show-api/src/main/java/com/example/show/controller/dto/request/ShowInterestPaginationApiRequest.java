package com.example.show.controller.dto.request;

import com.example.show.service.dto.request.InterestShowPaginationServiceRequest;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Max;
import java.time.LocalDateTime;
import java.util.UUID;

public record ShowInterestPaginationApiRequest(
    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId,

    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorValue / 최초 조회라면 null")
    LocalDateTime cursorValue,

    @Parameter(example = "30")
    @Max(value = 30, message = "조회하는 데이터의 최대 개수는 30입니다.")
    Integer size
) {
    public ShowInterestPaginationApiRequest {
        if (size == null) {
            size = 30;
        }
    }

    public InterestShowPaginationServiceRequest toServiceRequest(UUID userId) {
        return InterestShowPaginationServiceRequest.builder()
            .userId(userId)
            .size(size)
            .cursorId(cursorId)
            .cursorValue(cursorValue)
            .build();
    }
}
