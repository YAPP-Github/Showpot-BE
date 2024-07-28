package org.example.dto.artist.request;

import java.util.UUID;
import lombok.Builder;
import org.example.vo.ArtistSortStandardDomainType;

@Builder
public record ArtistSearchPaginationDomainRequest(

    ArtistSortStandardDomainType sortStandard,
    UUID cursor,
    int size,
    String search
) {

}
