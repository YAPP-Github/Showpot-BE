package org.example.dto.genre.response;

import java.util.List;
import java.util.UUID;

public record GenreNamesWithShowIdDomainResponse(
    UUID showId,
    List<GenreNameDomainResponse> genreNames
) {

}
