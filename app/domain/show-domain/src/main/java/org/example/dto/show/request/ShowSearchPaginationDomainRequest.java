package org.example.dto.show.request;

import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowSearchPaginationDomainRequest(
    UUID cursor,
    int size,
    String search
) {

}
