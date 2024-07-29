package org.example.dto.artist.response;

import java.util.UUID;

public record ArtistUnsubscriptionDomainResponse(
    UUID id,
    String koreanName,
    String englishName,
    String image
) {

}
