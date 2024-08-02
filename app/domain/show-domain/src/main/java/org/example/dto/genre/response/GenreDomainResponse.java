package org.example.dto.genre.response;

import java.util.UUID;
import lombok.Builder;

@Builder
public record GenreDomainResponse(
    UUID id,
    String name
) {

}
