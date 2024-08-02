package com.example.genre.service.dto.param;

import java.util.UUID;
import org.example.dto.genre.response.GenreDomainResponse;

public record GenreUnsubscriptionPaginationServiceParam(
    UUID id,
    String name
) {

    public GenreUnsubscriptionPaginationServiceParam(GenreDomainResponse response) {
        this(
            response.id(),
            response.name()
        );
    }
}
