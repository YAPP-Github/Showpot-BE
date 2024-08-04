package org.example.dto.genre.response;

import java.util.UUID;
import lombok.Builder;

/*
 * 엔티티 조회 객체
 */

@Builder
public record GenreDomainResponse(
    UUID id,
    String name
) {

}
