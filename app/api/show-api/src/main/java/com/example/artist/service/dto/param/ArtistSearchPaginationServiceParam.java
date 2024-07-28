package com.example.artist.service.dto.param;

import java.util.UUID;
import org.example.dto.artist.response.SimpleArtistResponse;

public record ArtistSearchPaginationServiceParam(
    UUID artistId,
    String artistImageUrl,
    String artistKoreanName,
    String artistEnglishName
) {

    public ArtistSearchPaginationServiceParam(SimpleArtistResponse response) {
        this(
            response.id(),
            response.image(),
            response.koreanName(),
            response.englishName()
        );
    }
}
