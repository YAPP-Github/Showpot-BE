package org.example.dto.artist.response;

import java.util.List;
import lombok.Builder;

@Builder
public record ArtistDetailPaginationDomainResponse(
    List<SimpleArtistDomainResponse> data,
    boolean hasNext
) {

}
