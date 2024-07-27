package com.example.artist.service.dto.request;

import com.example.artist.vo.ArtistSortStandardApiType;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.request.ArtistSearchPaginationDomainRequest;
import org.example.util.StringNormalizer;

@Builder
public record ArtistSearchPaginationServiceRequest(
    ArtistSortStandardApiType sortStandard,
    UUID cursor,
    int size,
    String search
) {

    public ArtistSearchPaginationDomainRequest toDomainRequest() {
        return ArtistSearchPaginationDomainRequest.builder()
            .sortStandard(sortStandard.toDomainType())
            .cursor(cursor)
            .size(size)
            .search(StringNormalizer.removeWhitespaceAndLowerCase(search))
            .build();
    }

}
