package com.example.artist.service.dto.request;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.request.ArtistGenreDomainRequest;
import org.example.vo.ArtistGenreType;

@Builder
public record ArtistGenreServiceRequest(
    UUID artistId,
    String name,
    String image,
    String spotifyId,
    List<String> genres
) {

    public ArtistGenreDomainRequest toDomainRequest() {
        String mappedGenres = genres.stream()
            .map(ArtistGenreType::findByGenreClassificationName)
            .filter(Objects::nonNull)
            .findFirst()
            .orElse(genres.get(0))
            .toLowerCase();

        return ArtistGenreDomainRequest.builder()
            .artistId(artistId)
            .name(name)
            .image(image)
            .spotifyId(spotifyId)
            .genreName(mappedGenres)
            .build();
    }

}
