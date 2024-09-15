package com.example.genre.controller.dto.request;

import com.example.genre.service.dto.request.GenreUnsubscriptionPaginationServiceRequest;
import com.example.vo.SubscriptionStatusApiType;
import io.swagger.v3.oas.annotations.Parameter;
import java.util.UUID;

public record GenreUnsubscriptionPaginationApiRequest(
    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId
) {

    public GenreUnsubscriptionPaginationServiceRequest toServiceRequest(UUID userId, int size) {
        return GenreUnsubscriptionPaginationServiceRequest.builder()
            .subscriptionStatusApiType(SubscriptionStatusApiType.UNSUBSCRIBED)
            .cursor(cursorId)
            .size(size)
            .userId(userId)
            .build();
    }
}
