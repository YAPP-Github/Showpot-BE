package org.example.dto.response;

import java.util.List;
import lombok.Builder;
import org.example.entity.InterestShow;

@Builder
public record InterestShowPaginationDomainResponse(
    boolean hasNext,
    List<InterestShow> data
) {

}
