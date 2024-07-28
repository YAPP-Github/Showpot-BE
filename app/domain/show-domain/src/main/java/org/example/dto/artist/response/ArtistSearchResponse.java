package org.example.dto.artist.response;

import java.util.UUID;

public record ArtistSearchResponse(
    UUID id,
    String koreanName,
    String englishName,
    String image
) {

}
