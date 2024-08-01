package com.example.genre.service.dto.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.genre.request.GenreUnsubscriptionPaginationDomainRequest;

@Builder
public record GenreUnsubscriptionPaginationServiceRequest(
    UUID cursor,
    int size,
    UUID userId
) {


    public GenreUnsubscriptionPaginationDomainRequest toDomainRequest(List<UUID> genreIds) {
        return GenreUnsubscriptionPaginationDomainRequest.builder()
            .cursor(cursor)
            .size(size)
            .genreIds(genreIds)
            .build();
    }
}
