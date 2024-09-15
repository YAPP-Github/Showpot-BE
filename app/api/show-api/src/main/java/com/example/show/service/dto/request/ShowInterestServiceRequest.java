package com.example.show.service.dto.request;

import java.util.UUID;
import lombok.Builder;
import org.example.dto.usershow.request.InterestShowDomainRequest;

@Builder
public record ShowInterestServiceRequest(
    UUID showId,
    UUID userId
) {

    public InterestShowDomainRequest toDomainRequest(UUID showId) {
        return InterestShowDomainRequest.builder()
            .showId(showId)
            .userId(userId())
            .build();
    }
}
