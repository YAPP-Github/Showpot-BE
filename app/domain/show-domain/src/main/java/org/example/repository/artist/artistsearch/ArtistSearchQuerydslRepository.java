package org.example.repository.artist.artistsearch;

import org.example.dto.artist.request.ArtistSearchPaginationDomainRequest;
import org.example.dto.artist.response.ArtistDetailPaginationResponse;

public interface ArtistSearchQuerydslRepository {

    ArtistDetailPaginationResponse searchArtist(ArtistSearchPaginationDomainRequest request);
}
