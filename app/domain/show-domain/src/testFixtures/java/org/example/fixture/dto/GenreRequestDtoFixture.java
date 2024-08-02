package org.example.fixture.dto;

import java.util.List;
import java.util.UUID;
import org.example.dto.genre.request.GenrePaginationDomainRequest;
import org.example.vo.SubscriptionStatus;

public class GenreRequestDtoFixture {

    public static GenrePaginationDomainRequest genrePaginationDomainRequest(
        SubscriptionStatus status,
        UUID cursor,
        int size,
        List<UUID> genreIds
    ) {
        return GenrePaginationDomainRequest.builder()
            .subscriptionStatus(status)
            .cursor(cursor)
            .size(size)
            .genreIds(genreIds)
            .build();
    }
}
