package org.example.dto.artist.response;

import java.util.List;
import java.util.UUID;

public record ArtistKoreanNamesWithShowIdDomainResponse(
    UUID showId,
    List<ArtistKoreanNameDomainResponse> koreanNameDomainResponses
) {

}
