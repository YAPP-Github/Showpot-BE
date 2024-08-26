package com.example.genre.service.dto.param;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.genre.response.GenreDomainResponse;

@Builder
public record GenrePaginationServiceParam(
    UUID id,
    String name,
    boolean isSubscribed
) {

    public static GenrePaginationServiceParam of(
        GenreDomainResponse genre,
        List<UUID> subscriptionGenreIds
    ) {
        boolean isSubscribed = subscriptionGenreIds.contains(genre.id());

        return GenrePaginationServiceParam.builder()
            .id(genre.id())
            .name(genre.name())
            .isSubscribed(isSubscribed)
            .build();
    }
}
