package com.example.genre.service.dto.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.genre.request.GenreSubscriptionPaginationRequest;

@Builder
public record GenreSubscriptionPaginationServiceRequest(
    UUID cursor,
    int size,
    UUID userId
) {


    public GenreSubscriptionPaginationRequest toDomainRequest(List<UUID> genreIds) {
        return GenreSubscriptionPaginationRequest.builder()
            .cursor(cursor)
            .size(size)
            .userId(userId)
            .genreIds(genreIds)
            .build();
    }
}
