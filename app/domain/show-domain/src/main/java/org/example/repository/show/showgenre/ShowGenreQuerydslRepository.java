package org.example.repository.show.showgenre;

import java.util.List;
import org.example.dto.genre.response.GenreNamesWithShowIdDomainParam;

public interface ShowGenreQuerydslRepository {

    List<GenreNamesWithShowIdDomainParam> findGenreNamesWithShowId();

}
