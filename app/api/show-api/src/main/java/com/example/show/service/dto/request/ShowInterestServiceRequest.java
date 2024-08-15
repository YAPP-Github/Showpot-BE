package com.example.show.service.dto.request;

import java.util.UUID;
import lombok.Builder;
import org.example.dto.request.InterestShowDomainRequest;

@Builder
public record ShowInterestServiceRequest(
    UUID showId,
    UUID userId
) {

    public InterestShowDomainRequest toDomainRequest() {
        return InterestShowDomainRequest.builder()
            .showId(showId())
            .userId(userId())
            .build();
    }
}
