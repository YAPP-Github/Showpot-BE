package org.example.repository.show;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.dto.show.request.ShowPaginationDomainRequest;
import org.example.dto.show.response.ShowDetailDomainResponse;
import org.example.dto.show.response.ShowInfoDomainResponse;
import org.example.dto.show.response.ShowPaginationDomainResponse;
import org.example.dto.show.response.ShowWithTicketingTimesDomainResponse;

public interface ShowQuerydslRepository {

    Optional<ShowDetailDomainResponse> findShowDetailById(UUID id);

    List<ShowWithTicketingTimesDomainResponse> findShowDetailWithTicketingTimes();

    ShowPaginationDomainResponse findShows(ShowPaginationDomainRequest request);

    Optional<ShowInfoDomainResponse> findShowInfoById(UUID id);
}
