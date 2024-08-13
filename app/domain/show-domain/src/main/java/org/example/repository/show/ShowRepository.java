package org.example.repository.show;

import java.util.List;
import java.util.UUID;
import org.example.entity.show.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, UUID>, ShowQuerydslRepository {

    List<Show> findShowsByIdIn(List<UUID> showIds);
}
