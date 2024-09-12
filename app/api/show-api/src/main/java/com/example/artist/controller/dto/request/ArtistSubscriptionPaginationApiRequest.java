package com.example.artist.controller.dto.request;

import com.example.artist.service.dto.request.ArtistSubscriptionPaginationServiceRequest;
import com.example.artist.vo.ArtistSortApiType;
import com.example.vo.SubscriptionStatusApiType;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.util.UUID;

@Schema
public record ArtistSubscriptionPaginationApiRequest(

    @Parameter(
        description = "정렬 기준, default: ENGLISH_NAME_ASC",
        schema = @Schema(implementation = ArtistSortApiType.class)
    )
    ArtistSortApiType sort,

    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId,

    @Parameter(description = "조회하는 데이터 개수", required = true)
    @Min(value = 10, message = "조회하는 데이터 개수는 최소 10개 이어야 합니다.")
    @Max(value = 30, message = "조회하는 데이터 개수는 최대 30개 이어야 합니다.")
    int size
) {

    public ArtistSubscriptionPaginationApiRequest(
        ArtistSortApiType sort,
        UUID cursorId,
        int size
    ) {
        this.sort = sort == null ? ArtistSortApiType.ENGLISH_NAME_ASC : sort;
        this.cursorId = cursorId;
        this.size = size;
    }

    public ArtistSubscriptionPaginationServiceRequest toServiceRequest(UUID userId) {
        return ArtistSubscriptionPaginationServiceRequest.builder()
            .subscriptionStatusApiType(SubscriptionStatusApiType.SUBSCRIBED)
            .size(size)
            .sortStandard(sort)
            .cursor(cursorId)
            .userId(userId)
            .build();
    }
}
