package org.example.dto.artist.response;

import java.util.UUID;

public record ArtistNameDomainResponse(
    UUID id,
    String name
) {

}
