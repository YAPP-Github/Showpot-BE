package com.example.show.service.dto.param;

import com.example.vo.TicketingAlertReservationTimeApiType;
import lombok.Builder;

@Builder
public record TicketingAlertReservationTimeServiceParam(
    TicketingAlertReservationTimeApiType time,
    boolean isReserved,
    boolean canReserve
) {

}
