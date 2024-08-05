package org.example.fixture.dto;

import java.util.List;
import java.util.UUID;
import org.example.dto.artist.request.ArtistFilterDomain;
import org.example.dto.artist.request.ArtistFilterTotalCountDomainRequest;
import org.example.dto.artist.request.ArtistPaginationDomainRequest;
import org.example.vo.ArtistGender;
import org.example.vo.ArtistSortStandardDomainType;
import org.example.vo.ArtistType;
import org.example.vo.SubscriptionStatus;

public class ArtistRequestDtoFixture {

    public static ArtistPaginationDomainRequest artistPaginationDomainRequest(
        SubscriptionStatus subscriptionStatus,
        int size,
        ArtistSortStandardDomainType artistSortStandardDomainType,
        UUID cursor,
        List<UUID> artistIds,
        ArtistFilterDomain artistFilterDomain
    ) {
        return ArtistPaginationDomainRequest.builder()
            .subscriptionStatus(subscriptionStatus)
            .size(size)
            .sortStandard(artistSortStandardDomainType)
            .cursor(cursor)
            .artistIds(artistIds)
            .artistFilterDomain(artistFilterDomain)
            .build();
    }

    public static ArtistFilterTotalCountDomainRequest artistFilterTotalCountDomainRequest(
        List<ArtistGender> artistGenders,
        List<ArtistType> artistTypes,
        List<UUID> genreIds,
        List<UUID> artistIds
    ) {
        return ArtistFilterTotalCountDomainRequest.builder()
            .artistGenders(artistGenders)
            .artistTypes(artistTypes)
            .genreIds(genreIds)
            .artistIds(artistIds)
            .build();
    }

}
