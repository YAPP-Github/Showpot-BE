package com.example.show.service.dto.param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.show.response.ShowAlertDomainResponse;

@Builder
public record ShowAlertPaginationServiceParam(
    UUID id,
    String title,
    LocalDate startAt,
    LocalDate endAt,
    String location,
    String image,
    LocalDateTime ticketingAt
) {

    public static ShowAlertPaginationServiceParam from(ShowAlertDomainResponse alertShow) {
        return ShowAlertPaginationServiceParam.builder()
            .id(alertShow.id())
            .title(alertShow.title())
            .startAt(alertShow.startAt())
            .endAt(alertShow.endAt())
            .location(alertShow.location())
            .image(alertShow.image())
            .ticketingAt(alertShow.ticketingAt())
            .build();
    }
}
