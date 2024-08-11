package com.example.artist.service.dto.request;

import com.example.artist.vo.ArtistApiType;
import com.example.artist.vo.ArtistGenderApiType;
import com.example.artist.vo.ArtistSortApiType;
import com.example.vo.SubscriptionStatusApiType;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.request.ArtistFilterDomain;
import org.example.dto.artist.request.ArtistPaginationDomainRequest;

@Builder
public record ArtistUnsubscriptionPaginationServiceRequest(
    SubscriptionStatusApiType subscriptionStatusApiType,
    ArtistSortApiType sortStandard,
    List<ArtistGenderApiType> artistGenderApiTypes,
    List<ArtistApiType> artistApiTypes,
    List<UUID> genreIds,
    UUID userId,
    UUID cursor,
    int size
) {

    public ArtistPaginationDomainRequest toDomainRequest(List<UUID> artistIds) {
        return buildDomainRequest(artistIds);
    }

    public ArtistPaginationDomainRequest toNonUserDomainRequest() {
        return buildDomainRequest(List.of());
    }

    private ArtistPaginationDomainRequest buildDomainRequest(List<UUID> artistIds) {
        var artistGenders = artistGenderApiTypes.stream()
            .map(ArtistGenderApiType::toDomainType)
            .toList();
        var artistTypes = artistApiTypes.stream()
            .map(ArtistApiType::toDomainType)
            .toList();

        ArtistFilterDomain artistFilterDomain = ArtistFilterDomain.builder()
            .artistGenders(artistGenders)
            .artistTypes(artistTypes)
            .genreIds(genreIds)
            .build();

        return ArtistPaginationDomainRequest.builder()
            .subscriptionStatus(subscriptionStatusApiType.toDomainType())
            .sortStandard(sortStandard.toDomainType())
            .artistIds(artistIds)
            .cursor(cursor)
            .size(size)
            .artistFilterDomain(artistFilterDomain)
            .build();
    }
}
