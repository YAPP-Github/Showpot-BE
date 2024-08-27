package org.example.dto.show.response;

import java.util.List;
import lombok.Builder;

@Builder
public record ShowTicketingPaginationDomainResponse(
    List<ShowTicketingDomainResponse> data,
    boolean hasNext
) {

}
