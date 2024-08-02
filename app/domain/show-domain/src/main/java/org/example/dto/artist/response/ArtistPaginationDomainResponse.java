package org.example.dto.artist.response;

import java.util.List;
import lombok.Builder;

@Builder
public record ArtistPaginationDomainResponse(
    List<ArtistSimpleDomainResponse> data,
    boolean hasNext
) {

}
