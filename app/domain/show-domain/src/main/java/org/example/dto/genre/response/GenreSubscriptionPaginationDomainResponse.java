package org.example.dto.genre.response;

import java.util.List;
import lombok.Builder;

@Builder
public record GenreSubscriptionPaginationDomainResponse(
    boolean hasNext,
    List<GenreSubscriptionDomainResponse> data
) {

}
