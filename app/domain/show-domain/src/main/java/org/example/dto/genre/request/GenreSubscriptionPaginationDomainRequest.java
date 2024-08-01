package org.example.dto.genre.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record GenreSubscriptionPaginationDomainRequest(
    UUID cursor,
    int size,
    List<UUID> genreIds
) {

}
