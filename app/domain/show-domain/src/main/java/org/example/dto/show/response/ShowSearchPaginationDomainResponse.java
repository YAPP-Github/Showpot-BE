package org.example.dto.show.response;

import java.util.List;
import lombok.Builder;

@Builder
public record ShowSearchPaginationDomainResponse(
    List<ShowSearchDomainResponse> data,
    boolean hasNext
) {

}
