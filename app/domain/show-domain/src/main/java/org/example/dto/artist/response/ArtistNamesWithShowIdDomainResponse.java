package org.example.dto.artist.response;

import java.util.List;
import java.util.UUID;

public record ArtistNamesWithShowIdDomainResponse(
    UUID showId,
    List<ArtistNameDomainResponse> koreanNameDomainResponses
) {

}
