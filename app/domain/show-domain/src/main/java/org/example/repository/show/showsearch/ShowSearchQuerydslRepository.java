package org.example.repository.show.showsearch;

import java.util.Optional;
import org.example.dto.show.ShowSearchResponse;

public interface ShowSearchQuerydslRepository {

    Optional<ShowSearchResponse> searchShow(String name);
}
