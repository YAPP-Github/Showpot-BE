package com.example.artist.service.dto.response;

import java.util.UUID;
import org.example.dto.artist.response.ArtistNameDomainResponse;

public record ArtistNameServiceResponse(
    UUID id,
    String name
) {
    public ArtistNameServiceResponse(ArtistNameDomainResponse artistKoreanNameResponse) {
        this(
            artistKoreanNameResponse.id(),
            artistKoreanNameResponse.name()
        );
    }


}
