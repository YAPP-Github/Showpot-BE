package com.example.genre.controller.dto.param;

import com.example.genre.service.dto.param.GenreSubscriptionPaginationServiceParam;
import java.util.UUID;

public record GenreSubscriptionPaginationApiParam(
    UUID id,
    String name
) {

    public GenreSubscriptionPaginationApiParam(
        GenreSubscriptionPaginationServiceParam response
    ) {
        this(
            response.id(),
            response.name()
        );
    }
}
