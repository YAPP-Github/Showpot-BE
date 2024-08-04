package org.example.repository.show;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.dto.show.response.ShowDetailDomainResponse;
import org.example.dto.show.response.ShowInfoDomainResponse;

public interface ShowQuerydslRepository {

    Optional<ShowDetailDomainResponse> findShowDetailById(UUID id);

    List<ShowInfoDomainResponse> findAllShowInfos();

    Optional<ShowInfoDomainResponse> findShowInfoById(UUID id);
}
