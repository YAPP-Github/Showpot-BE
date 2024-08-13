package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.TicketingAlertReservationStatusServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record TicketingAlertReservationStatusApiResponse(

    @Schema(description = "공연 티켓팅 24 시간 전")
    boolean before24,

    @Schema(description = "공연 티켓팅 6 시간 전")
    boolean before6,

    @Schema(description = "공연 티켓팅 1 시간 전")
    boolean before1
) {

    public static TicketingAlertReservationStatusApiResponse from(
        TicketingAlertReservationStatusServiceResponse response
    ) {
        return TicketingAlertReservationStatusApiResponse.builder()
            .before24(response.before24())
            .before6(response.before6())
            .before1(response.before1())
            .build();
    }
}
