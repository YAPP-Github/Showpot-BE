package com.example.show.service.dto.param;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.show.response.ShowSearchDomainResponse;

@Builder
public record ShowSearchPaginationServiceParam(
    UUID id,
    String title,
    LocalDate startDateAt,
    LocalDate endDateAt,
    String location,
    String image
) {

    public static ShowSearchPaginationServiceParam from(ShowSearchDomainResponse response) {
        return ShowSearchPaginationServiceParam.builder()
            .id(response.id())
            .title(response.title())
            .startDateAt(response.startDateAt())
            .endDateAt(response.endDateAt())
            .location(response.location())
            .image(response.image())
            .build();
    }
}
