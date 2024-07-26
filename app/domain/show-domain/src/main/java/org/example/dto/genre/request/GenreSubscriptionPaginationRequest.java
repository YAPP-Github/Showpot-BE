package org.example.dto.genre.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record GenreSubscriptionPaginationRequest(
    UUID cursor,
    int size,
    UUID userId,
    List<UUID> genreIds
) {

}
