package com.example.artist.service.dto.response;

import java.util.UUID;
import org.example.dto.artist.response.ArtistKoreanNameDomainResponse;

public record ArtistKoreanNameServiceResponse(
    UUID id,
    String koreanName
) {
    public ArtistKoreanNameServiceResponse(ArtistKoreanNameDomainResponse artistKoreanNameResponse) {
        this(
            artistKoreanNameResponse.id(),
            artistKoreanNameResponse.koreanName()
        );
    }


}
