package org.example.repository.artist.artistsearch;

import org.example.dto.artist.request.ArtistSearchPaginationDomainRequest;
import org.example.dto.artist.response.ArtistDetailPaginationDomainResponse;

public interface ArtistSearchQuerydslRepository {

    ArtistDetailPaginationDomainResponse searchArtist(ArtistSearchPaginationDomainRequest request);
}
