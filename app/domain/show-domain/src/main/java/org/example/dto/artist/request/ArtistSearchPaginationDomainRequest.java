package org.example.dto.artist.request;

import java.util.UUID;
import lombok.Builder;

@Builder
public record ArtistSearchPaginationDomainRequest(
    UUID userId,
    String search,
    int limit,
    int offset
) {

}
