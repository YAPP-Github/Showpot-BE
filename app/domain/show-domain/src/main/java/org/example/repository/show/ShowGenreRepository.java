package org.example.repository.show;

import java.util.UUID;
import org.example.entity.show.ShowGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowGenreRepository extends JpaRepository<ShowGenre, UUID> {

}
