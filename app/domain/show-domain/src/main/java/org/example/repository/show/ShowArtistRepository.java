package org.example.repository.show;

import java.util.List;
import java.util.UUID;
import org.example.entity.show.ShowArtist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowArtistRepository extends JpaRepository<ShowArtist, UUID> {
    List<ShowArtist> findAllByShowId(UUID id);
}
