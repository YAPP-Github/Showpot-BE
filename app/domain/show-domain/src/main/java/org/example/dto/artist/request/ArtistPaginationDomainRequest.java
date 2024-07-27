package org.example.dto.artist.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.vo.ArtistSortStandardDomainType;

@Builder
public record ArtistPaginationDomainRequest(
    int size,
    ArtistSortStandardDomainType sortStandard,
    UUID cursor,
    List<UUID> artistIds
) {

}
