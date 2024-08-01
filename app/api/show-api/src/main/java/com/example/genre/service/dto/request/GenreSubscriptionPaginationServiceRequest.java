package com.example.genre.service.dto.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.genre.request.GenreSubscriptionPaginationDomainRequest;

@Builder
public record GenreSubscriptionPaginationServiceRequest(
    UUID cursor,
    int size,
    UUID userId
) {


    public GenreSubscriptionPaginationDomainRequest toDomainRequest(List<UUID> genreIds) {
        return GenreSubscriptionPaginationDomainRequest.builder()
            .cursor(cursor)
            .size(size)
            .genreIds(genreIds)
            .build();
    }
}
