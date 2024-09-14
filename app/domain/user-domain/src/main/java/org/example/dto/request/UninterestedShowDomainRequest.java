package org.example.dto.request;

import java.util.UUID;
import lombok.Builder;

@Builder
public record UninterestedShowDomainRequest(
    UUID showId,
    UUID userId
) {

}
