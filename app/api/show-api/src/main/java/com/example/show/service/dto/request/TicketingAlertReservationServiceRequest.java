package com.example.show.service.dto.request;

import com.example.show.controller.vo.TicketingAlertTimeApiType;
import com.example.show.controller.vo.TicketingApiType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.request.TicketingAlertReservationDomainRequest;

@Builder
public record TicketingAlertReservationServiceRequest(

    UUID userId,
    UUID showId,
    TicketingApiType type,
    List<TicketingAlertTimeApiType> alertTimes
) {

    public TicketingAlertReservationDomainRequest toDomainRequest(
        String name,
        LocalDateTime ticketingAt
    ) {
        return TicketingAlertReservationDomainRequest.builder()
            .userId(userId)
            .showId(showId)
            .type(type.toDomainType())
            .name(name)
            .ticketingAt(ticketingAt)
            .alertTimes(TicketingAlertTimeApiType.availableReserveTimeToDomainType(ticketingAt))
            .build();
    }
}
