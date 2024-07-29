package org.example.dto.artist.response;

import java.util.List;
import lombok.Builder;

@Builder
public record ArtistSubscriptionPaginationDomainResponse(
    List<ArtistSubscriptionDomainResponse> data,
    boolean hasNext
) {

}
