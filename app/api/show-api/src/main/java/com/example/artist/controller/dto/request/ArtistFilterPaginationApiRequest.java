package com.example.artist.controller.dto.request;

import com.example.artist.service.dto.request.ArtistFilterPaginationServiceRequest;
import com.example.artist.vo.ArtistApiType;
import com.example.artist.vo.ArtistGenderApiType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public record ArtistFilterPaginationApiRequest(
    @Schema(description = "아티스트 성별")
    List<ArtistGenderApiType> artistGenderApiTypes,

    @Schema(description = "아티스트 타입")
    List<ArtistApiType> artistApiTypes,

    @Schema(description = "장르 ID 목록")
    List<UUID> genreIds,

    @Schema(description = "이전 페이지네이션 마지막 데이터의 ID / 최초 조회라면 null")
    UUID cursor,

    @Schema(description = "페이지네이션 크기")
    @NotNull(message = "페이지네이션 크기는 필수 입력값입니다.")
    Integer size
) {

    public ArtistFilterPaginationApiRequest {
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
            .artistGenderApiTypes(artistGenderApiTypes)
            .artistApiTypes(artistApiTypes)
            .genreIds(genreIds)
            .userId(userId)
            .cursor(cursor)
            .size(size)
            .build();
    }
}
