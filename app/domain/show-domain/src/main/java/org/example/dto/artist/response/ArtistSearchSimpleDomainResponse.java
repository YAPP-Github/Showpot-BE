package org.example.dto.artist.response;

import java.util.UUID;
import lombok.Builder;

@Builder
public record ArtistSearchSimpleDomainResponse(
    UUID id,
    String name,
    String image,
    String spotifyId
) {

}
