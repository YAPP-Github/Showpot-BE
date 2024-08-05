package org.example.repository.artist.artistsearch;

import org.example.dto.artist.request.ArtistSearchPaginationDomainRequest;
import org.example.dto.artist.response.ArtistPaginationDomainResponse;

public interface ArtistSearchQuerydslRepository {

    ArtistPaginationDomainResponse searchArtist(ArtistSearchPaginationDomainRequest request);
}
