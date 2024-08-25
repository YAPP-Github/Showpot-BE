package com.example.artist.service.dto.request;

import com.example.artist.vo.ArtistSortApiType;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.request.ArtistSearchPaginationDomainRequest;
import org.example.util.StringNormalizer;

@Builder
public record ArtistSearchPaginationServiceRequest(
    UUID userId,
    ArtistSortApiType sortStandard,
    UUID cursor,
    int size,
    String search
) {

    public ArtistSearchPaginationDomainRequest toDomainRequest() {
        return ArtistSearchPaginationDomainRequest.builder()
            .userId(userId)
            .sortStandard(sortStandard.toDomainType())
            .cursor(cursor)
            .size(size)
            .search(StringNormalizer.removeWhitespaceAndLowerCase(search))
            .build();
    }
}
