package org.example.dto.show.request;

import java.util.UUID;
import lombok.Builder;

@Builder
public record UninterestedShowDomainRequest(
    UUID showId,
    UUID userId
) {

}
