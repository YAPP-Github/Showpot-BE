package com.example.artist.service.dto.request;

import com.example.artist.vo.ArtistSortApiType;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.request.ArtistSearchPaginationDomainRequest;

@Builder
public record ArtistSearchPaginationServiceRequest(
    UUID userId,
    ArtistSortApiType sortStandard,
    int cursor,
    int size,
    String search
) {

    public ArtistSearchPaginationDomainRequest toDomainRequest() {
        return ArtistSearchPaginationDomainRequest.builder()
            .userId(userId)
            .sortStandard(sortStandard.toDomainType())
            .limit(size)
            .offset(cursor)
            .search(search)
            .build();
    }
}
