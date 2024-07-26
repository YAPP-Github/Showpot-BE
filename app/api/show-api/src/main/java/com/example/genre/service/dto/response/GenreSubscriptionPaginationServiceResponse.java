package com.example.genre.service.dto.response;

import java.util.List;
import lombok.Builder;

@Builder
public record GenreSubscriptionPaginationServiceResponse(
    boolean hasNext,
    List<GenreSubscribeServiceResponse> data
) {

}
