package com.example.artist.service.dto.response;

import java.util.List;
import java.util.UUID;
import org.example.dto.artist.response.ArtistDetailDomainResponse;

public record ArtistDetailServiceResponse(
    UUID id,
    String name,
    String image,
    List<String> genreNames
) {

    public ArtistDetailServiceResponse(ArtistDetailDomainResponse artistDetailResponse) {
        this(
            artistDetailResponse.id(),
            artistDetailResponse.name(),
            artistDetailResponse.image(),
            artistDetailResponse.genreNames()
        );
    }

}
