package org.example.repository.show.showartist;

import java.util.List;
import java.util.UUID;
import org.example.entity.show.ShowArtist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowArtistRepository extends JpaRepository<ShowArtist, UUID> {

    List<ShowArtist> findAllByShowIdAndIsDeletedFalse(UUID showId);

    List<ShowArtist> findAllByArtistIdAndIsDeletedFalse(UUID artistId);
}
