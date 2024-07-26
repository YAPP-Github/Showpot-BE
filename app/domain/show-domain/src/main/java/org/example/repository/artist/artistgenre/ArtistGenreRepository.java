package org.example.repository.artist.artistgenre;

import java.util.List;
import java.util.UUID;
import org.example.entity.artist.ArtistGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistGenreRepository extends JpaRepository<ArtistGenre, UUID> {

    List<ArtistGenre> findAllByArtistIdAndIsDeletedFalse(UUID artistId);

    List<ArtistGenre> findAllByGenreIdAndIsDeletedFalse(UUID genreId);
}
