package com.example.show.service.dto.param;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.show.response.ShowAlertDomainResponse;

@Builder
public record ShowAlertPaginationServiceParam(
    UUID id,
    String title,
    LocalDate startDate,
    LocalDate endDate,
    String location,
    String image
) {

    public static ShowAlertPaginationServiceParam from(ShowAlertDomainResponse alertShow) {
        return ShowAlertPaginationServiceParam.builder()
            .id(alertShow.id())
            .title(alertShow.title())
            .startDate(alertShow.startDate())
            .endDate(alertShow.endDate())
            .location(alertShow.location())
            .image(alertShow.image())
            .build();
    }
}
