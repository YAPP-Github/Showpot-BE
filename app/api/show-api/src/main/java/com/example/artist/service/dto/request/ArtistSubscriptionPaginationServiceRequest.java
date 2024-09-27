package com.example.artist.service.dto.request;

import com.example.vo.SubscriptionStatusApiType;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.request.ArtistPaginationDomainRequest;

@Builder
public record ArtistSubscriptionPaginationServiceRequest(
    SubscriptionStatusApiType subscriptionStatusApiType,
    int size,
    UUID cursor,
    UUID userId
) {

    public ArtistPaginationDomainRequest toDomainRequest(List<UUID> artistIds) {
        return ArtistPaginationDomainRequest.builder()
            .subscriptionStatus(subscriptionStatusApiType.toDomainType())
            .size(size)
            .artistIds(artistIds)
            .cursor(cursor)
            .build();
    }
}
