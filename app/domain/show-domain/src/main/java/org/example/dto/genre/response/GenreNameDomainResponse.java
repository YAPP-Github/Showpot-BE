package org.example.dto.genre.response;

import java.util.UUID;

public record GenreNameDomainResponse(
    UUID id,
    String name
) {

}
