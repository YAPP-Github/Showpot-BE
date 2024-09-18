package com.example.genre.controller.dto.param;

import com.example.genre.service.dto.param.GenreUnsubscriptionPaginationServiceParam;
import java.util.UUID;

public record GenreUnsubscriptionPaginationApiParam(
    UUID id,
    String name
) {

    public GenreUnsubscriptionPaginationApiParam(
        GenreUnsubscriptionPaginationServiceParam response
    ) {
        this(
            response.id(),
            response.name()
        );
    }
}
