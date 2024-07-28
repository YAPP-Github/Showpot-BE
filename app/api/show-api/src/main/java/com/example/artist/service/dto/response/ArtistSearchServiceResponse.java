package com.example.artist.service.dto.response;

import java.util.UUID;
import org.example.dto.artist.response.ArtistSearchResponse;

public record ArtistSearchServiceResponse(
    UUID id,
    String koreanName,
    String englishName,
    String image
) {

    public ArtistSearchServiceResponse(ArtistSearchResponse artistSearchResponse) {
        this(
            artistSearchResponse.id(),
            artistSearchResponse.koreanName(),
            artistSearchResponse.englishName(),
            artistSearchResponse.image()
        );
    }
}
