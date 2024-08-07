package com.example.artist.controller.dto.response;

import com.example.artist.service.dto.response.ArtistKoreanNameServiceResponse;
import java.util.UUID;

public record ArtistKoreanNameApiResponse(
    UUID id,
    String koreanName
) {

    public ArtistKoreanNameApiResponse(
        ArtistKoreanNameServiceResponse artistKoreanNameServiceResponse
    ) {
        this(
            artistKoreanNameServiceResponse.id(),
            artistKoreanNameServiceResponse.koreanName()
        );
    }


}
