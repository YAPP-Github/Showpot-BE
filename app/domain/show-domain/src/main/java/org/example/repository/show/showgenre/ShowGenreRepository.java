package org.example.repository.show.showgenre;

import java.util.List;
import java.util.UUID;
import org.example.entity.show.ShowGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowGenreRepository extends JpaRepository<ShowGenre, UUID>,
    ShowGenreQuerydslRepository {

    List<ShowGenre> findAllByShowIdAndIsDeletedFalse(UUID showId);

    List<ShowGenre> findAllByGenreIdAndIsDeletedFalse(UUID genreId);
}
