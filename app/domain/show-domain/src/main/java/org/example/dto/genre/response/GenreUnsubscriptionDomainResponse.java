package org.example.dto.genre.response;

import java.util.UUID;
import lombok.Builder;

@Builder
public record GenreUnsubscriptionDomainResponse(
    UUID id,
    String name
) {

}
