package com.example.artist.service.dto.param;

import java.util.UUID;
import org.example.dto.artist.response.ArtistFilterDomainResponse;

public record ArtistFilterPaginationServiceParam(
    UUID artistId,
    String artistImageUrl,
    String artistKoreanName,
    String artistEnglishName
) {

    public ArtistFilterPaginationServiceParam(ArtistFilterDomainResponse response) {
        this(
            response.id(),
            response.image(),
            response.koreanName(),
            response.englishName()
        );
    }
}
