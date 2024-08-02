package org.example.fixture.dto;

import java.util.List;
import java.util.UUID;
import org.example.dto.artist.request.ArtistFilterPaginationDomainRequest;
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
        List<UUID> artistIds
    ) {
        return ArtistPaginationDomainRequest.builder()
            .subscriptionStatus(subscriptionStatus)
            .size(size)
            .sortStandard(artistSortStandardDomainType)
            .cursor(cursor)
            .artistIds(artistIds)
            .build();
    }

    public static ArtistFilterPaginationDomainRequest artistFilterPaginationDomainRequest(
        List<ArtistGender> artistGenders,
        List<ArtistType> artistTypes,
        List<UUID> genreIds,
        List<UUID> artistIds,
        UUID cursor,
        int size
    ) {
        return ArtistFilterPaginationDomainRequest.builder()
            .artistGenders(artistGenders)
            .artistTypes(artistTypes)
            .genreIds(genreIds)
            .artistIds(artistIds)
            .cursor(cursor)
            .size(size)
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
