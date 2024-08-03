package com.example.artist.service.dto.param;

import java.util.UUID;
import org.example.dto.artist.response.ArtistSimpleDomainResponse;

public record ArtistFilterPaginationServiceParam(
    UUID artistId,
    String artistImageUrl,
    String artistKoreanName,
    String artistEnglishName
) {

    public ArtistFilterPaginationServiceParam(ArtistSimpleDomainResponse response) {
        this(
            response.id(),
            response.image(),
            response.koreanName(),
            response.englishName()
        );
    }
}
