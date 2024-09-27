package com.example.artist.controller.dto.response;

import com.example.artist.service.dto.response.ArtistDetailServiceResponse;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ArtistDetailApiFormResponse(
    UUID id,
    String name,
    String image,
    List<String> genreNames
) {

    public ArtistDetailApiFormResponse(
        ArtistDetailServiceResponse artistDetailServiceResponse
    ) {
        this(
            artistDetailServiceResponse.id(),
            artistDetailServiceResponse.name(),
            artistDetailServiceResponse.image(),
            artistDetailServiceResponse.genreNames()
        );
    }

}
