package org.example.dto.genre.response;

import java.util.List;
import java.util.UUID;

public record GenreNamesWithShowIdDomainParam(
    UUID showId,
    List<GenreNameDomainResponse> genreNames
) {

}
