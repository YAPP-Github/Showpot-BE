package org.example.fixture.dto;

import java.util.List;
import java.util.UUID;
import org.example.dto.artist.request.ArtistFilterPaginationDomainRequest;
import org.example.dto.artist.request.ArtistFilterTotalCountDomainRequest;
import org.example.dto.artist.request.ArtistSubscriptionPaginationDomainRequest;
import org.example.dto.artist.request.ArtistUnsubscriptionPaginationDomainRequest;
import org.example.vo.ArtistGender;
import org.example.vo.ArtistSortStandardDomainType;
import org.example.vo.ArtistType;

public class ArtistRequestDtoFixture {

    public static ArtistSubscriptionPaginationDomainRequest artistSubscriptionPaginationDomainRequest(
        int size,
        ArtistSortStandardDomainType artistSortStandardDomainType,
        UUID cursor,
        List<UUID> artistIds
    ) {
        return ArtistSubscriptionPaginationDomainRequest.builder()
            .size(size)
            .sortStandard(artistSortStandardDomainType)
            .cursor(cursor)
            .artistIds(artistIds)
            .build();
    }

    public static ArtistUnsubscriptionPaginationDomainRequest artistUnsubscriptionPaginationDomainRequest(
        int size,
        ArtistSortStandardDomainType artistSortStandardDomainType,
        UUID cursor,
        List<UUID> artistIds
    ) {
        return ArtistUnsubscriptionPaginationDomainRequest.builder()
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
