package org.example.dto.artist.response;

import java.util.UUID;

public record SimpleArtistResponse(
    UUID id,
    String koreanName,
    String englishName,
    String image
) {

}
