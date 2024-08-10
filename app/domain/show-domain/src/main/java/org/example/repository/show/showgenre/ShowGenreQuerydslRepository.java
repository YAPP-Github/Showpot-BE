package org.example.repository.show.showgenre;

import java.util.List;
import org.example.dto.genre.response.GenreNamesWithShowIdDomainResponse;

public interface ShowGenreQuerydslRepository {

    List<GenreNamesWithShowIdDomainResponse> findGenreNamesWithShowId();

}
