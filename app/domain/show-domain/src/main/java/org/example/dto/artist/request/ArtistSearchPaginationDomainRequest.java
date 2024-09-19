package org.example.dto.artist.request;

import java.util.UUID;
import lombok.Builder;
import org.example.vo.ArtistSortType;

@Builder
public record ArtistSearchPaginationDomainRequest(

    UUID userId,
    ArtistSortType sortStandard,
    String search,
    int limit,
    int offset
) {

}
