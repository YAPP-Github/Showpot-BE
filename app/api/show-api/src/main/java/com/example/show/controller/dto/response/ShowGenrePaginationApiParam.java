package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.ShowGenreSimpleServiceResponse;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowGenrePaginationApiParam(
    UUID id,
    String name
) {

    public static ShowGenrePaginationApiParam from(ShowGenreSimpleServiceResponse response) {
        return ShowGenrePaginationApiParam.builder()
            .id(response.id())
            .name(response.name())
            .build();
    }
}
