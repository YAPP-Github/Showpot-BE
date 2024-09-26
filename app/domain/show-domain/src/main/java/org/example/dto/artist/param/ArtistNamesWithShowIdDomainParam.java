package org.example.dto.artist.param;

import java.util.List;
import java.util.UUID;
import org.example.dto.artist.response.ArtistNameDomainResponse;

public record ArtistNamesWithShowIdDomainParam(
    UUID showId,
    List<ArtistNameDomainResponse> koreanNameDomainResponses
) {

}
