package org.example.fixture.dto;

import java.util.List;
import java.util.UUID;
import org.example.dto.artist.request.ArtistPaginationDomainRequest;
import org.example.vo.SubscriptionStatus;

public class ArtistRequestDtoFixture {

    public static ArtistPaginationDomainRequest artistPaginationDomainRequest(
        SubscriptionStatus subscriptionStatus,
        int size,
        UUID cursor,
        List<UUID> artistIds
    ) {
        return ArtistPaginationDomainRequest.builder()
            .subscriptionStatus(subscriptionStatus)
            .size(size)
            .cursor(cursor)
            .artistIds(artistIds)
            .build();
    }

}
