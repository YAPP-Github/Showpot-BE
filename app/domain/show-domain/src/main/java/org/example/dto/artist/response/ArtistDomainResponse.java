package org.example.dto.artist.response;

import java.util.UUID;

/**
 * 엔티티 조회 객체
 */
public record ArtistDomainResponse(
    UUID id,
    String name,
    String image
) {

}
