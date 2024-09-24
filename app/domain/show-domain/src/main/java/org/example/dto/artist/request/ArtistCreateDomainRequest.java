package org.example.dto.artist.request;

import java.util.List;

public record ArtistCreateDomainRequest(
    List<ArtistGenreDomainRequest> artistGenres
) {

}
