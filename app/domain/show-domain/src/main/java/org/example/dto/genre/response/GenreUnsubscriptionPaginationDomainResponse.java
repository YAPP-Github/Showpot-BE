package org.example.dto.genre.response;

import java.util.List;
import lombok.Builder;

@Builder
public record GenreUnsubscriptionPaginationDomainResponse(
    boolean hasNext,
    List<GenreUnsubscriptionDomainResponse> data
) {

}
