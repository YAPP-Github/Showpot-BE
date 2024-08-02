package com.example.artist.service.dto.request;

import com.example.artist.vo.ArtistSortStandardApiType;
import com.example.artist.vo.SubscriptionStatusApiType;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.request.ArtistPaginationDomainRequest;

@Builder
public record ArtistUnsubscriptionPaginationServiceRequest(
    SubscriptionStatusApiType subscriptionStatusApiType,
    int size,
    ArtistSortStandardApiType sortStandard,
    UUID cursor,
    UUID userId
) {

    public ArtistPaginationDomainRequest toDomainRequest(List<UUID> artistIds) {
        return ArtistPaginationDomainRequest.builder()
            .subscriptionStatus(subscriptionStatusApiType.toDomainType())
            .size(size)
            .sortStandard(sortStandard.toDomainType())
            .artistIds(artistIds)
            .cursor(cursor)
            .build();
    }
}
