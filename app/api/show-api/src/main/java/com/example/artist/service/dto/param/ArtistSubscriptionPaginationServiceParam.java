package com.example.artist.service.dto.param;

import java.util.UUID;
import org.example.dto.artist.response.SimpleArtistResponse;

public record ArtistSubscriptionPaginationServiceParam(
    UUID artistId,
    String artistImageUrl,
    String artistKoreanName,
    String artistEnglishName
) {

    public ArtistSubscriptionPaginationServiceParam(SimpleArtistResponse response) {
        this(
            response.id(),
            response.image(),
            response.koreanName(),
            response.englishName()
        );
    }
}
