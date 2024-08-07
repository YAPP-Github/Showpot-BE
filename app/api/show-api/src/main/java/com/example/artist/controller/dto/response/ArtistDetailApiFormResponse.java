package com.example.artist.controller.dto.response;

import com.example.artist.service.dto.response.ArtistDetailServiceResponse;
import com.example.artist.vo.ArtistApiType;
import com.example.artist.vo.ArtistGenderApiType;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ArtistDetailApiFormResponse(
    UUID id,
    String koreanName,
    String englishName,
    String image,
    String country,
    ArtistGenderApiType artistGenderApiType,
    ArtistApiType artistApiType,
    List<String> genreNames
) {

    public ArtistDetailApiFormResponse(
        ArtistDetailServiceResponse artistDetailServiceResponse
    ) {
        this(
            artistDetailServiceResponse.id(),
            artistDetailServiceResponse.koreanName(),
            artistDetailServiceResponse.englishName(),
            artistDetailServiceResponse.image(),
            artistDetailServiceResponse.country(),
            artistDetailServiceResponse.artistGenderApiType(),
            artistDetailServiceResponse.artistApiType(),
            artistDetailServiceResponse.genreNames()
        );
    }

}
