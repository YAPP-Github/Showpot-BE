package org.example.dto.artist.response;

import java.util.List;
import java.util.UUID;
import org.example.vo.ArtistGender;
import org.example.vo.ArtistType;

public record ArtistDetailDomainResponse(
    UUID id,
    String koreanName,
    String englishName,
    String image,
    String country,
    ArtistGender artistGender,
    ArtistType artistType,
    List<String> genreNames
) {

}
