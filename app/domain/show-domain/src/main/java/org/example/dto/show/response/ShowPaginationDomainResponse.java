package org.example.dto.show.response;

import java.util.List;
import lombok.Builder;

@Builder
public record ShowPaginationDomainResponse(
    boolean hasNext,
    List<ShowDetailDomainResponse> data
) {

}
