package com.example.artist.controller.dto.request;

import com.example.artist.service.dto.request.ArtistUnsubscriptionPaginationServiceRequest;
import com.example.artist.vo.ArtistApiType;
import com.example.artist.vo.ArtistGenderApiType;
import com.example.artist.vo.ArtistSortStandardApiType;
import com.example.vo.SubscriptionStatusApiType;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;
import org.example.util.ValidateStatus;

@Schema
public record ArtistUnsubscriptionPaginationApiRequest(
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

    public ArtistUnsubscriptionPaginationApiRequest(
        ArtistSortStandardApiType sortStandard,
        List<ArtistGenderApiType> artistGenderApiTypes,
        List<ArtistApiType> artistApiTypes,
        List<UUID> genreIds,
        UUID cursor,
        int size
    ) {
        this.sortStandard =
            sortStandard == null ? ArtistSortStandardApiType.ENGLISH_NAME_ASC : sortStandard;
        this.artistGenderApiTypes = ValidateStatus.checkNullOrEmpty(artistGenderApiTypes);
        this.artistApiTypes = ValidateStatus.checkNullOrEmpty(artistApiTypes);
        this.genreIds = ValidateStatus.checkNullOrEmpty(genreIds);
        this.cursor = cursor;
        this.size = size;
    }


    public ArtistUnsubscriptionPaginationServiceRequest toServiceRequest(UUID userId) {
        return ArtistUnsubscriptionPaginationServiceRequest.builder()
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

    public ArtistUnsubscriptionPaginationServiceRequest toNonUserServiceRequest() {
        return ArtistUnsubscriptionPaginationServiceRequest.builder()
            .subscriptionStatusApiType(SubscriptionStatusApiType.UNSUBSCRIBED)
            .sortStandard(sortStandard)
            .artistGenderApiTypes(artistGenderApiTypes)
            .artistApiTypes(artistApiTypes)
            .genreIds(genreIds)
            .userId(null)
            .cursor(cursor)
            .size(size)
            .build();
    }
}
