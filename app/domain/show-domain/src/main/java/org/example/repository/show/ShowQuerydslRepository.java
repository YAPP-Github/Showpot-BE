package org.example.repository.show;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.dto.show.response.ShowInfoResponse;

public interface ShowQuerydslRepository {
    List<ShowInfoResponse> findAllShowInfos();

    Optional<ShowInfoResponse> findShowInfoById(UUID id);
}
