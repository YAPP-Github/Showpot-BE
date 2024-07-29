package org.example.dto.artist.response;

import java.util.List;
import lombok.Builder;

@Builder
public record ArtistUnsubscriptionPaginationDomainResponse(
    List<ArtistUnsubscriptionDomainResponse> data,
    boolean hasNext
) {

}
