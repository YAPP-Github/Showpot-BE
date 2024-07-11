package com.example.artist.service.dto.response;

import java.util.UUID;
import org.example.dto.artist.response.ArtistKoreanNameResponse;

public record ArtistKoreanNameServiceResponse(
    UUID id,
    String koreanName
) {
    public ArtistKoreanNameServiceResponse(ArtistKoreanNameResponse artistKoreanNameResponse) {
        this(
            artistKoreanNameResponse.id(),
            artistKoreanNameResponse.koreanName()
        );
    }


}
