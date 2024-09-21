package org.example.port.dto.request;

import lombok.Builder;

@Builder
public record ArtistSearchPortRequest(
    String accessToken,
    String search,
    int limit,
    int offset
) {

}
