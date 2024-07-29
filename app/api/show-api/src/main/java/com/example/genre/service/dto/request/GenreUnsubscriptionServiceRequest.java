package com.example.genre.service.dto.request;

import java.util.List;
import java.util.UUID;

public record GenreUnsubscriptionServiceRequest(
    List<UUID> genreIds,
    UUID userId
) {

}
