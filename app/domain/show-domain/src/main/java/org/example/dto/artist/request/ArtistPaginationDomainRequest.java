package org.example.dto.artist.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.vo.ArtistSortStandardDomainType;
import org.example.vo.SubscriptionStatus;

@Builder
public record ArtistPaginationDomainRequest(
    SubscriptionStatus subscriptionStatus,
    int size,
    ArtistSortStandardDomainType sortStandard,
    UUID cursor,
    List<UUID> artistIds,
    ArtistFilterDomain artistFilterDomain
) {

}
