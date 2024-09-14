package com.example.show.controller.dto.response;

import com.example.show.controller.dto.param.TicketingAlertReservationTimeApiParam;
import com.example.show.service.dto.response.TicketingAlertReservationServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Builder;

@Builder
public record TicketingAlertReservationApiResponse(
    @Schema(description = "공연 알림 예약 시간 목록")
    List<TicketingAlertReservationTimeApiParam> times
) {

    public static TicketingAlertReservationApiResponse from(
        TicketingAlertReservationServiceResponse response
    ) {
        return new TicketingAlertReservationApiResponse(
            response.times().stream()
                .map(TicketingAlertReservationTimeApiParam::from)
                .toList()
        );
    }
}
