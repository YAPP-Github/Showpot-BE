package com.example.artist.service.dto.param;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.response.ArtistSimpleDomainResponse;

@Builder
public record ArtistSearchPaginationServiceParam(
    UUID artistId,
    String artistImageUrl,
    String artistKoreanName,
    String artistEnglishName,
    boolean isSubscribed
) {

    public static ArtistSearchPaginationServiceParam from(
        ArtistSimpleDomainResponse response,
        List<UUID> artistSubscriptions
    ) {
        boolean isSubscribed = artistSubscriptions.contains(response.id());

        return ArtistSearchPaginationServiceParam.builder()
            .artistId(response.id())
            .artistImageUrl(response.image())
            .artistKoreanName(response.koreanName())
            .artistEnglishName(response.englishName())
            .isSubscribed(isSubscribed)
            .build();
    }
}
