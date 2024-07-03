package com.example.artist.service.dto.response;

import com.example.artist.vo.ArtistApiType;
import com.example.artist.vo.ArtistGenderApiType;
import java.util.List;
import java.util.UUID;
import org.example.dto.artist.response.ArtistDetailResponse;

public record ArtistDetailServiceFormResponse(
    UUID id,
    String koreanName,
    String englishName,
    String country,
    ArtistGenderApiType artistGenderApiType,
    ArtistApiType artistApiType,
    List<String> genreNames
) {

    public ArtistDetailServiceFormResponse(ArtistDetailResponse artistDetailResponse) {
        this(
            artistDetailResponse.id(),
            artistDetailResponse.koreanName(),
            artistDetailResponse.englishName(),
            artistDetailResponse.country(),
            ArtistGenderApiType.valueOf(artistDetailResponse.artistGender().name()),
            ArtistApiType.valueOf(artistDetailResponse.artistType().name()),
            artistDetailResponse.genreNames()
        );
    }

}
