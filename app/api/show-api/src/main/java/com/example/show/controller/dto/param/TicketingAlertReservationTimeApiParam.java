package com.example.show.controller.dto.param;

import com.example.show.service.dto.param.TicketingAlertReservationTimeServiceParam;
import com.example.vo.TicketingAlertReservationTimeApiType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record TicketingAlertReservationTimeApiParam(
    @Schema(description = "예약 시간")
    TicketingAlertReservationTimeApiType time,
    @Schema(description = "예약 여부")
    boolean isReserved,
    @Schema(description = "예약 가능 여부")
    boolean canReserve
) {

    public static TicketingAlertReservationTimeApiParam from(
        TicketingAlertReservationTimeServiceParam param
    ) {
        return TicketingAlertReservationTimeApiParam.builder()
            .time(param.time())
            .isReserved(param.isReserved())
            .canReserve(param.canReserve())
            .build();
    }
}
