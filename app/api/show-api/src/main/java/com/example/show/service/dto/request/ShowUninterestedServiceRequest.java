package com.example.show.service.dto.request;

import java.util.UUID;
import lombok.Builder;
import org.example.dto.show.request.UninterestedShowDomainRequest;

@Builder
public record ShowUninterestedServiceRequest(
    UUID showId,
    UUID userId
) {

    public UninterestedShowDomainRequest toDomainRequest(UUID showId) {
        return UninterestedShowDomainRequest.builder()
            .showId(showId)
            .userId(userId())
            .build();
    }
}
