package com.example.artist.controller.dto.request;

import com.example.artist.service.dto.request.ArtistSubscriptionPaginationServiceRequest;
import com.example.artist.vo.ArtistSortApiType;
import com.example.vo.SubscriptionStatusApiType;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;

@Schema
public record ArtistSubscriptionPaginationApiRequest(

    @Parameter(
        description = "정렬 기준, default: ENGLISH_NAME_ASC",
        schema = @Schema(implementation = ArtistSortApiType.class)
    )
    ArtistSortApiType sort,

    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId
) {

    public ArtistSubscriptionPaginationApiRequest(
        ArtistSortApiType sort,
        UUID cursorId
    ) {
        this.sort = sort == null ? ArtistSortApiType.ENGLISH_NAME_ASC : sort;
        this.cursorId = cursorId;
    }

    public ArtistSubscriptionPaginationServiceRequest toServiceRequest(UUID userId, int size) {
        return ArtistSubscriptionPaginationServiceRequest.builder()
            .subscriptionStatusApiType(SubscriptionStatusApiType.SUBSCRIBED)
            .size(size)
            .sortStandard(sort)
            .cursor(cursorId)
            .userId(userId)
            .build();
    }
}
