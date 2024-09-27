package org.example.dto.artist.response;

import java.util.List;
import java.util.UUID;

public record ArtistDetailDomainResponse(
    UUID id,
    String name,
    String image,
    List<String> genreNames
) {

}
