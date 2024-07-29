package org.example.repository.artist.artistsearch;

import java.util.List;
import java.util.UUID;
import org.example.entity.artist.ArtistSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistSearchRepository extends JpaRepository<ArtistSearch, UUID>,
    ArtistSearchQuerydslRepository {
    List<ArtistSearch> findAllByArtistIdAndIsDeletedFalse(UUID artistId);
}
