package com.example.show.service.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.show.response.ShowTicketingDomainResponse;

@Builder
public record ShowPaginationServiceResponse(
    UUID id,
    String title,
    LocalDateTime ticketingAt,
    String location,
    String image,
    boolean isOpen
) {
    public static ShowPaginationServiceResponse of(
        ShowTicketingDomainResponse response,
        LocalDateTime now
    ) {
        return ShowPaginationServiceResponse.builder()
            .id(response.id())
            .title(response.title())
            .ticketingAt(response.ticketingAt())
            .location(response.location())
            .image(response.image())
            .isOpen(response.ticketingAt().isBefore(now))
            .build();
    }
}
