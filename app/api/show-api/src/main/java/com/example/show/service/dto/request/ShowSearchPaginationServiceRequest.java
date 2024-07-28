package com.example.show.service.dto.request;

import java.util.UUID;
import lombok.Builder;
import org.example.dto.show.request.ShowSearchPaginationDomainRequest;
import org.example.util.StringNormalizer;

@Builder
public record ShowSearchPaginationServiceRequest(
    UUID cursor,
    int size,
    String search
) {

    public ShowSearchPaginationDomainRequest toDomainRequest() {
        return ShowSearchPaginationDomainRequest.builder()
            .cursor(cursor)
            .size(size)
            .search(StringNormalizer.removeWhitespaceAndLowerCase(search))
            .build();
    }
}
