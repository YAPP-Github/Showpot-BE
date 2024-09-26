package com.example.artist.service.dto.param;

import java.util.UUID;
import org.example.dto.artist.response.ArtistNameDomainResponse;

public record ArtistNameServiceParam(
    UUID id,
    String name
) {
    public ArtistNameServiceParam(ArtistNameDomainResponse artistKoreanNameResponse) {
        this(
            artistKoreanNameResponse.id(),
            artistKoreanNameResponse.name()
        );
    }


}
