package org.example.repository.show;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.dto.show.response.ShowInfoDomainResponse;

public interface ShowQuerydslRepository {
    List<ShowInfoDomainResponse> findAllShowInfos();

    Optional<ShowInfoDomainResponse> findShowInfoById(UUID id);
}
