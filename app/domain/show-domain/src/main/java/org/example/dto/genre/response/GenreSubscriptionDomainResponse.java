package org.example.dto.genre.response;

import java.util.UUID;

public record GenreSubscriptionDomainResponse(
    UUID id,
    String name
) {

}
