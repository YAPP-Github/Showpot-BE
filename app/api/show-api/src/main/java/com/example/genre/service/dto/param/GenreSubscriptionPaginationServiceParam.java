package com.example.genre.service.dto.param;

import java.util.UUID;
import org.example.dto.genre.response.GenreSubscriptionDomainResponse;

public record GenreSubscriptionPaginationServiceParam(
    UUID id,
    String name
) {

    public GenreSubscriptionPaginationServiceParam(GenreSubscriptionDomainResponse response) {
        this(
            response.id(),
            response.name()
        );
    }
}
