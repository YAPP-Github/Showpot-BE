package com.example.genre.service.dto.response;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record GenreSubscriptionServiceResponse(
    List<UUID> successSubscriptionGenreIds
) {

}
