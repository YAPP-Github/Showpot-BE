package org.example.dto.artist.request;

import java.util.List;

public record ArtistWithGenreCreateDomainRequest(
    List<ArtistGenreDomainRequest> artistGenres
) {

}
