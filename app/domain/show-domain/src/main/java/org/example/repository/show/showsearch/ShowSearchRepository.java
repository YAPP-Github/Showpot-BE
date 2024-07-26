package org.example.repository.show.showsearch;

import java.util.UUID;
import org.example.entity.show.ShowSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSearchRepository extends JpaRepository<ShowSearch, UUID>,
    ShowSearchQuerydslRepository {

}
