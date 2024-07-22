package org.example.dto.genre;

import java.util.UUID;

public record GenreNameResponse(
    UUID id,
    String name
) {

}
