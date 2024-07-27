package com.example.artist.service.dto.request;

import com.example.artist.vo.ArtistApiType;
import com.example.artist.vo.ArtistGenderApiType;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.entity.artist.Artist;
import org.example.vo.ArtistGender;
import org.example.vo.ArtistType;
import org.springframework.web.multipart.MultipartFile;

@Builder
public record ArtistUpdateServiceRequest(
    String koreanName,
    String englishName,
    MultipartFile image,
    String country,
    ArtistGenderApiType artistGenderApiType,
    ArtistApiType artistApiType,
    List<UUID> genreIds
) {

    public Artist toArtist(String imageUrl) {
        return Artist.builder()
            .koreanName(koreanName)
            .englishName(englishName)
            .image(imageUrl)
            .country(country)
            .artistGender(ArtistGender.valueOf(artistGenderApiType.name()))
            .artistType(ArtistType.valueOf(artistApiType.name()))
            .build();
    }
}
