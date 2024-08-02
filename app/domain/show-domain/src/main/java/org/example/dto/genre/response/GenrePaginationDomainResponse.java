package org.example.dto.genre.response;

import java.util.List;
import lombok.Builder;

@Builder
public record GenrePaginationDomainResponse(
    boolean hasNext,
    List<GenreDomainResponse> data
) {

}
