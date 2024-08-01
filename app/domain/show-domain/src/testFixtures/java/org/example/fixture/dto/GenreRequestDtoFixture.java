package org.example.fixture.dto;

import java.util.List;
import java.util.UUID;
import org.example.dto.genre.request.GenreSubscriptionPaginationDomainRequest;
import org.example.dto.genre.request.GenreUnsubscriptionPaginationDomainRequest;

public class GenreRequestDtoFixture {

    public static GenreSubscriptionPaginationDomainRequest genreSubscriptionPaginationDomainRequest(
        UUID cursor,
        int size,
        List<UUID> genreIds
    ) {
        return GenreSubscriptionPaginationDomainRequest.builder()
            .cursor(cursor)
            .size(size)
            .genreIds(genreIds)
            .build();
    }

    public static GenreUnsubscriptionPaginationDomainRequest genreUnsubscriptionPaginationDomainRequest(
        UUID cursor,
        int size,
        List<UUID> genreIds
    ) {
        return GenreUnsubscriptionPaginationDomainRequest.builder()
            .cursor(cursor)
            .size(size)
            .genreIds(genreIds)
            .build();
    }
}
