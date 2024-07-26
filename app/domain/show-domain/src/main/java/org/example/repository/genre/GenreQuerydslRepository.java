package org.example.repository.genre;

import java.util.List;
import java.util.UUID;
import org.example.entity.genre.Genre;

public interface GenreQuerydslRepository {

    List<Genre> findAllInId(List<UUID> ids);
}
