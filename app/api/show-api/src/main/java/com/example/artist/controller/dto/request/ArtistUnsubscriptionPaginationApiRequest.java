package com.example.artist.controller.dto.request;

import com.example.artist.service.dto.request.ArtistUnsubscriptionPaginationServiceRequest;
import com.example.vo.SubscriptionStatusApiType;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Max;
import java.util.UUID;

public record ArtistUnsubscriptionPaginationApiRequest(
    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId,

    @Parameter(example = "30")
    @Max(value = 30, message = "조회하는 데이터의 최대 개수는 30입니다.")
    Integer size
) {

    public ArtistUnsubscriptionPaginationApiRequest(
        UUID cursorId,
        Integer size
    ) {
        this.cursorId = cursorId;
        this.size = size == null ? 30 : size;
    }

    public ArtistUnsubscriptionPaginationServiceRequest toServiceRequest(UUID userId) {
        return ArtistUnsubscriptionPaginationServiceRequest.builder()
            .subscriptionStatusApiType(SubscriptionStatusApiType.UNSUBSCRIBED)
            .userId(userId)
            .cursor(cursorId)
            .size(size)
            .build();
    }
}
