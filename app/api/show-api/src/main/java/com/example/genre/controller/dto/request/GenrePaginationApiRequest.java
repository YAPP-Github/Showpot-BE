package com.example.genre.controller.dto.request;

import com.example.genre.service.dto.request.GenrePaginationServiceRequest;
import com.example.vo.SubscriptionStatusApiType;
import io.swagger.v3.oas.annotations.Parameter;
import java.util.UUID;
import org.example.security.dto.AuthenticatedUser;

public record GenrePaginationApiRequest(
    @Parameter(description = "이전 페이지네이션 마지막 데이터의 ID / 최초 조회라면 null")
    UUID cursor,

    @Parameter(description = "조회하는 데이터 개수", required = true)
    int size
) {

    public GenrePaginationServiceRequest toServiceRequest(AuthenticatedUser user) {
        UUID userId = user == null ? null : user.userId();

        return GenrePaginationServiceRequest.builder()
            .type(SubscriptionStatusApiType.DEFAULTED)
            .cursor(cursor)
            .size(size)
            .userId(userId)
            .build();
    }
}
