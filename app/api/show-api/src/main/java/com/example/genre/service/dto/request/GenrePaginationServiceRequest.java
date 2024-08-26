package com.example.genre.service.dto.request;

import com.example.vo.SubscriptionStatusApiType;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.genre.request.GenrePaginationDomainRequest;

@Builder
public record GenrePaginationServiceRequest(
    SubscriptionStatusApiType type,
    UUID cursor,
    int size,
    UUID userId
) {
    public GenrePaginationDomainRequest toDomainRequest() {
        return GenrePaginationDomainRequest.builder()
            .subscriptionStatus(type.toDomainType())
            .cursor(cursor)
            .size(size)
            .genreIds(List.of())
            .build();
    }

}
