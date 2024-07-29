package org.example.dto.genre.response;

import java.util.UUID;

public record GenreUnsubscriptionDomainResponse(
    UUID id,
    String name
) {

}
