package com.example.artist.controller.dto.request;

import com.example.artist.service.dto.request.ArtistFilterTotalCountServiceRequest;
import com.example.artist.vo.ArtistApiType;
import com.example.artist.vo.ArtistGenderApiType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;

public record ArtistFilterTotalCountApiRequest(
    @Schema(description = "아티스트 성별")
    List<ArtistGenderApiType> artistGenderApiTypes,

    @Schema(description = "아티스트 타입")
    List<ArtistApiType> artistApiTypes,

    @Schema(description = "장르 ID 목록")
    List<UUID> genreIds
) {

    public ArtistFilterTotalCountApiRequest {
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

    public ArtistFilterTotalCountServiceRequest toServiceRequest(UUID userId) {
        return ArtistFilterTotalCountServiceRequest.builder()
            .artistGenderApiTypes(artistGenderApiTypes)
            .artistApiTypes(artistApiTypes)
            .genreIds(genreIds)
            .userId(userId)
            .build();
    }
}
