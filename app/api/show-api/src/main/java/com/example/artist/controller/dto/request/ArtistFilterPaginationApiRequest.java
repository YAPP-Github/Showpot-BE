package com.example.artist.controller.dto.request;

import com.example.artist.service.dto.request.ArtistFilterPaginationServiceRequest;
import com.example.artist.vo.ArtistApiType;
import com.example.artist.vo.ArtistGenderApiType;
import com.example.artist.vo.ArtistSortStandardApiType;
import com.example.vo.SubscriptionStatusApiType;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;

public record ArtistFilterPaginationApiRequest(

    @Parameter(
        description = "정렬 기준, default: ENGLISH_NAME_ASC",
        schema = @Schema(implementation = ArtistSortStandardApiType.class)
    )
    ArtistSortStandardApiType sortStandard,

    @Parameter(description = "아티스트 성별 목록")
    List<ArtistGenderApiType> artistGenderApiTypes,

    @Parameter(description = "아티스트 타입 목록")
    List<ArtistApiType> artistApiTypes,

    @Parameter(description = "장르 ID 목록")
    List<UUID> genreIds,

    @Parameter(description = "이전 페이지네이션 마지막 데이터의 ID / 최초 조회라면 null")
    UUID cursor,

    @Parameter(description = "조회하는 데이터 개수", required = true)
    int size
) {

    public ArtistFilterPaginationApiRequest {
        if (sortStandard == null) {
            sortStandard = ArtistSortStandardApiType.ENGLISH_NAME_ASC;
        }

        if (artistGenderApiTypes == null || artistGenderApiTypes.isEmpty()) {
            artistGenderApiTypes = List.of();
        }

        if (artistApiTypes == null || artistApiTypes.isEmpty()) {
            artistApiTypes = List.of();
        }

        if (genreIds == null || genreIds.isEmpty()) {
            genreIds = List.of();
        }
    }

    public ArtistFilterPaginationServiceRequest toServiceRequest(UUID userId) {
        return ArtistFilterPaginationServiceRequest.builder()
            .subscriptionStatusApiType(SubscriptionStatusApiType.UNSUBSCRIBED)
            .sortStandard(sortStandard)
            .artistGenderApiTypes(artistGenderApiTypes)
            .artistApiTypes(artistApiTypes)
            .genreIds(genreIds)
            .userId(userId)
            .cursor(cursor)
            .size(size)
            .build();
    }
}
