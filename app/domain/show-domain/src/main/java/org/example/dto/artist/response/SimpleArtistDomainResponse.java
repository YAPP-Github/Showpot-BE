package org.example.dto.artist.response;

import java.util.UUID;
import lombok.Builder;

@Builder
public record SimpleArtistDomainResponse(
    UUID id,
    String koreanName,
    String englishName,
    String image
) {

}
