package com.example.artist.service.dto.response;

import com.example.artist.vo.ArtistApiType;
import com.example.artist.vo.ArtistGenderApiType;
import java.util.List;
import java.util.UUID;
import org.example.dto.artist.response.ArtistDetailResponse;

public record ArtistDetailServiceResponse(
    UUID id,
    String koreanName,
    String englishName,
    String image,
    String country,
    ArtistGenderApiType artistGenderApiType,
    ArtistApiType artistApiType,
    List<String> genreNames
) {

    public ArtistDetailServiceResponse(ArtistDetailResponse artistDetailResponse) {
        this(
            artistDetailResponse.id(),
            artistDetailResponse.koreanName(),
            artistDetailResponse.englishName(),
            artistDetailResponse.image(),
            artistDetailResponse.country(),
            ArtistGenderApiType.valueOf(artistDetailResponse.artistGender().name()),
            ArtistApiType.valueOf(artistDetailResponse.artistType().name()),
            artistDetailResponse.genreNames()
        );
    }

}
