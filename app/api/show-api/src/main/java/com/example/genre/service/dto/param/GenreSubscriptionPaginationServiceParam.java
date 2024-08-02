package com.example.genre.service.dto.param;

import java.util.UUID;
import org.example.dto.genre.response.GenreDomainResponse;

public record GenreSubscriptionPaginationServiceParam(
    UUID id,
    String name
) {

    public GenreSubscriptionPaginationServiceParam(GenreDomainResponse response) {
        this(
            response.id(),
            response.name()
        );
    }
}
