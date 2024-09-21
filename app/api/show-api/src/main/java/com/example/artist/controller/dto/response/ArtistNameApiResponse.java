package com.example.artist.controller.dto.response;

import com.example.artist.service.dto.response.ArtistNameServiceResponse;
import java.util.UUID;

public record ArtistNameApiResponse(
    UUID id,
    String name
) {

    public ArtistNameApiResponse(
        ArtistNameServiceResponse artistKoreanNameServiceResponse
    ) {
        this(
            artistKoreanNameServiceResponse.id(),
            artistKoreanNameServiceResponse.name()
        );
    }


}
