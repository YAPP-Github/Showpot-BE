package com.example.genre.service.dto.param;

import java.util.UUID;
import org.example.dto.genre.response.GenreUnsubscriptionDomainResponse;

public record GenreUnsubscriptionPaginationServiceParam(
    UUID id,
    String name
) {

    public GenreUnsubscriptionPaginationServiceParam(GenreUnsubscriptionDomainResponse response) {
        this(
            response.id(),
            response.name()
        );
    }
}
