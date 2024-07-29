package org.example.dto.artist.response;

import java.util.UUID;

public record ArtistKoreanNameDomainResponse(
    UUID id,
    String koreanName
) {

}
