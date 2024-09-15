package com.example.genre.controller.dto.request;

import com.example.genre.service.dto.request.GenreUnsubscriptionPaginationServiceRequest;
import com.example.vo.SubscriptionStatusApiType;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Max;
import java.util.UUID;

public record GenreUnsubscriptionPaginationApiRequest(
    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId,

    @Parameter(example = "30")
    @Max(value = 30, message = "조회하는 데이터의 최대 개수는 30입니다.")
    Integer size
) {
    public GenreUnsubscriptionPaginationApiRequest {
        if (size == null) {
            size = 30;
        }
    }

    public GenreUnsubscriptionPaginationServiceRequest toServiceRequest(UUID userId) {
        return GenreUnsubscriptionPaginationServiceRequest.builder()
            .subscriptionStatusApiType(SubscriptionStatusApiType.UNSUBSCRIBED)
            .cursor(cursorId)
            .size(size)
            .userId(userId)
            .build();
    }
}
