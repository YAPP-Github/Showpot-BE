package org.example.dto.usershow.response;

import java.util.List;
import lombok.Builder;
import org.example.entity.usershow.InterestShow;

@Builder
public record InterestShowPaginationDomainResponse(
    boolean hasNext,
    List<InterestShow> data
) {

}
