package org.example.dto.genre.response;

import java.util.UUID;

/**
 * 엔티티 조회 객체
 */
public record GenreDomainResponse(
    UUID id,
    String name
) {

}
