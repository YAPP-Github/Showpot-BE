package com.example.show.service.dto.param;

import com.example.show.controller.vo.TicketingAlertTimeApiType;
import lombok.Builder;

@Builder
public record TicketingAlertReservationTimeServiceParam(
    TicketingAlertTimeApiType time,
    boolean isReserved,
    boolean canReserve
) {

}
