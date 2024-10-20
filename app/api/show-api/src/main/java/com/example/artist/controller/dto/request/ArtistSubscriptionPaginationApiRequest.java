package com.example.artist.controller.dto.request;

import com.example.artist.service.dto.request.ArtistSubscriptionPaginationServiceRequest;
import com.example.vo.SubscriptionStatusApiType;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import java.util.UUID;

@Schema
public record ArtistSubscriptionPaginationApiRequest(

    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId,

    @Parameter(example = "30")
    @Max(value = 30, message = "조회하는 데이터의 최대 개수는 30입니다.")
    Integer size
) {

    public ArtistSubscriptionPaginationApiRequest(
        UUID cursorId,
        Integer size
    ) {
        this.cursorId = cursorId;
        this.size = size == null ? 30 : size;
    }

    public ArtistSubscriptionPaginationServiceRequest toServiceRequest(UUID userId) {
        return ArtistSubscriptionPaginationServiceRequest.builder()
            .subscriptionStatusApiType(SubscriptionStatusApiType.SUBSCRIBED)
            .size(size)
            .cursor(cursorId)
            .userId(userId)
            .build();
    }
}
