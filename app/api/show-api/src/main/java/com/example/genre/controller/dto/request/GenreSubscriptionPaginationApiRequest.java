package com.example.genre.controller.dto.request;

import com.example.genre.service.dto.request.GenreSubscriptionPaginationServiceRequest;
import com.example.vo.SubscriptionStatusApiType;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.util.UUID;

public record GenreSubscriptionPaginationApiRequest(
    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId,

    @Parameter(description = "조회하는 데이터 개수")
    @Min(value = 10, message = "조회하는 데이터 개수는 최소 10개 이어야 합니다.")
    @Max(value = 30, message = "조회하는 데이터 개수는 최대 30개 이어야 합니다.")
    int size
) {

    public GenreSubscriptionPaginationServiceRequest toServiceRequest(UUID userId) {
        return GenreSubscriptionPaginationServiceRequest.builder()
            .subscriptionStatusApiType(SubscriptionStatusApiType.SUBSCRIBED)
            .cursor(cursorId)
            .size(size)
            .userId(userId)
            .build();
    }
}
