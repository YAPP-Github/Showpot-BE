package org.example.dto.artist.response;

import java.util.List;
import lombok.Builder;

@Builder
public record ArtistFilterPaginationDomainResponse(
    List<ArtistFilterDomainResponse> data,
    boolean hasNext
) {

}
