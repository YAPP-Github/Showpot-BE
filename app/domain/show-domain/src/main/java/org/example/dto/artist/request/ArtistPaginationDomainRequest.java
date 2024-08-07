package org.example.dto.artist.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.vo.SubscriptionStatus;
import org.example.vo.ArtistSortType;

@Builder
public record ArtistPaginationDomainRequest(
    SubscriptionStatus subscriptionStatus,
    int size,
    ArtistSortType sortStandard,
    UUID cursor,
    List<UUID> artistIds,
    ArtistFilterDomain artistFilterDomain
) {

}
