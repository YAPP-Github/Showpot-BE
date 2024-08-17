package org.example.dto.show.response;

import java.util.List;
import lombok.Builder;

@Builder
public record ShowAlertPaginationDomainResponse(
    List<ShowAlertDomainResponse> data,
    boolean hasNext
) {

}
