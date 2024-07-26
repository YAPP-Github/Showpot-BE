package org.example.dto.genre.response;

import java.util.List;
import lombok.Builder;

@Builder
public record GenreSubscriptionPaginationResponse(
    boolean hasNext,
    List<GenreSubscribeResponse> data
) {

}
