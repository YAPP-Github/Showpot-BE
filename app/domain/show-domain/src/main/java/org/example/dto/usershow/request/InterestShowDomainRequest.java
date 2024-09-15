package org.example.dto.usershow.request;

import java.util.UUID;
import lombok.Builder;

@Builder
public record InterestShowDomainRequest(
    UUID showId,
    UUID userId
) {

}
