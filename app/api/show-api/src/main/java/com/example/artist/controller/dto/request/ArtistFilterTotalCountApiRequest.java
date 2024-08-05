package com.example.artist.controller.dto.request;

import com.example.artist.service.dto.request.ArtistFilterTotalCountServiceRequest;
import com.example.artist.vo.ArtistApiType;
import com.example.artist.vo.ArtistGenderApiType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;
import org.example.util.ValidateStatus;

public record ArtistFilterTotalCountApiRequest(
    @Schema(description = "아티스트 성별")
    List<ArtistGenderApiType> artistGenderApiTypes,

    @Schema(description = "아티스트 타입")
    List<ArtistApiType> artistApiTypes,

    @Schema(description = "장르 ID 목록")
    List<UUID> genreIds
) {

    public ArtistFilterTotalCountApiRequest(
        List<ArtistGenderApiType> artistGenderApiTypes,
        List<ArtistApiType> artistApiTypes,
        List<UUID> genreIds
    ) {
        this.artistGenderApiTypes = ValidateStatus.checkNullOrEmpty(artistGenderApiTypes);
        this.artistApiTypes = ValidateStatus.checkNullOrEmpty(artistApiTypes);
        this.genreIds = ValidateStatus.checkNullOrEmpty(genreIds);
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
