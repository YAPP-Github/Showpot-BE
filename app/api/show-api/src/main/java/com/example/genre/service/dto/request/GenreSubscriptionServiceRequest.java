package com.example.genre.service.dto.request;

import java.util.List;
import java.util.UUID;

public record GenreSubscriptionServiceRequest(
    List<UUID> genreIds,
    UUID userId
) {

}
