package com.example.artist.service.dto.request;

import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.request.ArtistSearchPaginationDomainRequest;

@Builder
public record ArtistSearchPaginationServiceRequest(
    UUID userId,
    int cursor,
    int size,
    String search
) {

    public ArtistSearchPaginationDomainRequest toDomainRequest() {
        return ArtistSearchPaginationDomainRequest.builder()
            .userId(userId)
            .limit(size)
            .offset(cursor)
            .search(search)
            .build();
    }
}
