package com.example.show.controller.dto.request;

import com.example.show.service.dto.request.InterestShowPaginationServiceRequest;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.UUID;

public record ShowInterestPaginationApiRequest(

    @Parameter(description = "페이지네이션 데이터 개수", required = true)
    @Min(value = 10, message = "조회하는 데이터 개수는 최소 10개 이어야 합니다.")
    @Max(value = 30, message = "조회하는 데이터 개수는 최대 30개 이어야 합니다.")
    int size,
    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId,

    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorValue / 최초 조회라면 null")
    LocalDateTime cursorValue
) {

    public InterestShowPaginationServiceRequest toServiceRequest(UUID userId) {
        return InterestShowPaginationServiceRequest.builder()
            .userId(userId)
            .size(size)
            .cursorId(cursorId)
            .cursorValue(cursorValue)
            .build();
    }
}
