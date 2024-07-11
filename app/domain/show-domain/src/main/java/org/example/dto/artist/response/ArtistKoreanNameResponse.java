package org.example.dto.artist.response;

import java.util.UUID;

public record ArtistKoreanNameResponse(
    UUID id,
    String koreanName
) {

}
