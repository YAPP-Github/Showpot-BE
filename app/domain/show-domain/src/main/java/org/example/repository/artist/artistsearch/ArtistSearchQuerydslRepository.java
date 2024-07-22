package org.example.repository.artist.artistsearch;

import java.util.Optional;
import org.example.dto.artist.response.ArtistSearchResponse;

public interface ArtistSearchQuerydslRepository {

    Optional<ArtistSearchResponse> searchArtist(String name);
}
