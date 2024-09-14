package com.example.show.controller.dto.param;

import com.example.show.service.dto.param.TicketingAlertReservationTimeServiceParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record TicketingAlertReservationTimeApiParam(
    @Schema(description = "예약 시간(기준: 분)")
    int beforeMinutes,
    @Schema(description = "예약 여부")
    boolean isReserved,
    @Schema(description = "예약 가능 여부")
    boolean canReserve
) {

    public static TicketingAlertReservationTimeApiParam from(
        TicketingAlertReservationTimeServiceParam param
    ) {
        return TicketingAlertReservationTimeApiParam.builder()
            .beforeMinutes(param.time().getMinutes())
            .isReserved(param.isReserved())
            .canReserve(param.canReserve())
            .build();
    }
}
