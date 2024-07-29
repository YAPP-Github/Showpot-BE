package com.example.artist.service.dto.request;

import com.example.artist.vo.ArtistSortStandardApiType;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.request.ArtistUnsubscriptionPaginationDomainRequest;

@Builder
public record ArtistUnsubscriptionPaginationServiceRequest(
    int size,
    ArtistSortStandardApiType sortStandard,
    UUID cursor,
    UUID userId
) {

    public ArtistUnsubscriptionPaginationDomainRequest toDomainRequest(List<UUID> artistIds) {
        return ArtistUnsubscriptionPaginationDomainRequest.builder()
            .size(size)
            .sortStandard(sortStandard.toDomainType())
            .artistIds(artistIds)
            .cursor(cursor)
            .build();
    }
}
