package com.example.genre.controller.dto.request;

import com.example.genre.service.dto.request.GenreUnsubscriptionPaginationServiceRequest;
import com.example.vo.SubscriptionStatusApiType;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Max;
import java.util.UUID;
import org.example.util.ValidatorCursorSize;

public record GenreUnsubscriptionPaginationApiRequest(
    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId,

    @Parameter(description = "조회하는 데이터 개수", required = true)
    @Max(value = 30, message = "조회하는 데이터 개수는 최대 30개 이어야 합니다.")
    Integer size
) {

    public GenreUnsubscriptionPaginationServiceRequest toServiceRequest(UUID userId) {
        return GenreUnsubscriptionPaginationServiceRequest.builder()
            .subscriptionStatusApiType(SubscriptionStatusApiType.UNSUBSCRIBED)
            .cursor(cursorId)
            .size(ValidatorCursorSize.getDefaultSize(size))
            .userId(userId)
            .build();
    }
}
