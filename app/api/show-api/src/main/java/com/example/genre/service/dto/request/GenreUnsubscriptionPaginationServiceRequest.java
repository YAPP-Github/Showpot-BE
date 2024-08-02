package com.example.genre.service.dto.request;

import com.example.vo.SubscriptionStatusApiType;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.genre.request.GenrePaginationDomainRequest;

@Builder
public record GenreUnsubscriptionPaginationServiceRequest(
    SubscriptionStatusApiType subscriptionStatusApiType,
    UUID cursor,
    int size,
    UUID userId
) {


    public GenrePaginationDomainRequest toDomainRequest(List<UUID> genreIds) {
        return GenrePaginationDomainRequest.builder()
            .subscriptionStatus(subscriptionStatusApiType.toDomainType())
            .cursor(cursor)
            .size(size)
            .genreIds(genreIds)
            .build();
    }
}
