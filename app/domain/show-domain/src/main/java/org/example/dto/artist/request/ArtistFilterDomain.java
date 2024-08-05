package org.example.dto.artist.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.vo.ArtistGender;
import org.example.vo.ArtistType;

@Builder
public record ArtistFilterDomain(
    List<ArtistGender> artistGenders,
    List<ArtistType> artistTypes,
    List<UUID> genreIds
) {

    public static ArtistFilterDomain defaultArtistFilterDomain() {
        return ArtistFilterDomain.builder()
            .artistGenders(List.of())
            .artistTypes(List.of())
            .genreIds(List.of())
            .build();
    }
}
