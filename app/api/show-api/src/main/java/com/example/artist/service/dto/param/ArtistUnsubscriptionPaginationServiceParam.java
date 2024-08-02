package com.example.artist.service.dto.param;

import java.util.UUID;
import org.example.dto.artist.response.ArtistSimpleDomainResponse;

public record ArtistUnsubscriptionPaginationServiceParam(
    UUID artistId,
    String artistImageUrl,
    String artistKoreanName,
    String artistEnglishName
) {

    public ArtistUnsubscriptionPaginationServiceParam(ArtistSimpleDomainResponse response) {
        this(
            response.id(),
            response.image(),
            response.koreanName(),
            response.englishName()
        );
    }
}
