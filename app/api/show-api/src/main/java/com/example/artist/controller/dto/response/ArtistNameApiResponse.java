package com.example.artist.controller.dto.response;

import com.example.artist.service.dto.param.ArtistNameServiceParam;
import java.util.UUID;

public record ArtistNameApiResponse(
    UUID id,
    String name
) {

    public ArtistNameApiResponse(
        ArtistNameServiceParam artistKoreanNameServiceResponse
    ) {
        this(
            artistKoreanNameServiceResponse.id(),
            artistKoreanNameServiceResponse.name()
        );
    }


}
