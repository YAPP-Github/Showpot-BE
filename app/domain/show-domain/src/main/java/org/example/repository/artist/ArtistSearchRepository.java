package org.example.repository.artist;

import java.util.UUID;
import org.example.entity.artist.ArtistSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistSearchRepository extends JpaRepository<ArtistSearch, UUID> {

}
