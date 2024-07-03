package com.example.artist.controller.dto.response;

import com.example.artist.service.dto.response.ArtistDetailServiceFormResponse;
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
    String country,
    ArtistGenderApiType artistGenderApiType,
    ArtistApiType artistApiType,
    List<String> genreNames
) {

    public ArtistDetailApiFormResponse(
        ArtistDetailServiceFormResponse artistDetailServiceFormResponse) {
        this(
            artistDetailServiceFormResponse.id(),
            artistDetailServiceFormResponse.koreanName(),
            artistDetailServiceFormResponse.englishName(),
            artistDetailServiceFormResponse.country(),
            artistDetailServiceFormResponse.artistGenderApiType(),
            artistDetailServiceFormResponse.artistApiType(),
            artistDetailServiceFormResponse.genreNames()
        );
    }

}
