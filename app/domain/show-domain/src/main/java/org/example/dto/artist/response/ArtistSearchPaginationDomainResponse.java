package org.example.dto.artist.response;

import java.util.List;
import lombok.Builder;

@Builder
public record ArtistSearchPaginationDomainResponse(
    List<ArtistSearchSimpleDomainResponse> data,
    int limit,
    int offset,
    boolean hasNext
) {



}
