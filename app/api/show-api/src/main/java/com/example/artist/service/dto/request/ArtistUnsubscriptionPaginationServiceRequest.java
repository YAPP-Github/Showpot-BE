package com.example.artist.service.dto.request;

import com.example.vo.SubscriptionStatusApiType;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.request.ArtistPaginationDomainRequest;

@Builder
public record ArtistUnsubscriptionPaginationServiceRequest(
    SubscriptionStatusApiType subscriptionStatusApiType,
    UUID userId,
    UUID cursor,
    int size
) {

    public ArtistPaginationDomainRequest toDomainRequest(List<UUID> artistIds) {
        return ArtistPaginationDomainRequest.builder()
            .subscriptionStatus(subscriptionStatusApiType.toDomainType())
            .artistIds(artistIds)
            .cursor(cursor)
            .size(size)
            .build();
    }
}
