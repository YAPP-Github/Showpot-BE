package org.example.repository.show;

import java.util.Optional;
import org.example.dto.show.ShowSearchDomainResponse;

public interface ShowSearchQuerydslRepository {

    Optional<ShowSearchDomainResponse> searchShow(String name);
}
