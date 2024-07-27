package com.example.artist.service.dto.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ArtistUnsubscriptionServiceRequest(
    List<UUID> artistIds,
    UUID userId
) {

}
