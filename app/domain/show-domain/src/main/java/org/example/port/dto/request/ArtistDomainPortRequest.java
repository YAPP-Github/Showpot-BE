package org.example.port.dto.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ArtistDomainPortRequest(
    UUID id,
    String name,
    String image,
    String spotifyId,
    List<String> genres
) {

}
