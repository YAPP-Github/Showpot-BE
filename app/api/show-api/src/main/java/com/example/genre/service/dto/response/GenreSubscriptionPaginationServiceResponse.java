package com.example.genre.service.dto.response;

import com.example.genre.service.dto.param.GenreSubscriptionPaginationServiceParam;
import java.util.List;
import lombok.Builder;

@Builder
public record GenreSubscriptionPaginationServiceResponse(
    boolean hasNext,
    List<GenreSubscriptionPaginationServiceParam> data
) {

}
