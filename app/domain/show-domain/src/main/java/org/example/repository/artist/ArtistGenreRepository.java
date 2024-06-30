package org.example.repository.artist;

import java.util.UUID;
import org.example.entity.artist.ArtistGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistGenreRepository extends JpaRepository<ArtistGenre, UUID> {

}
