package org.example.repository.show.showsearch;

import org.example.dto.show.request.ShowSearchPaginationDomainRequest;
import org.example.dto.show.response.ShowSearchPaginationDomainResponse;

public interface ShowSearchQuerydslRepository {

    ShowSearchPaginationDomainResponse searchShow(ShowSearchPaginationDomainRequest request);
}
