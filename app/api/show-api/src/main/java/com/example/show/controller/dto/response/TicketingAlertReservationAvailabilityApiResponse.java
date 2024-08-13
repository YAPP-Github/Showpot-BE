package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.TicketingAlertReservationAvailabilityServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record TicketingAlertReservationAvailabilityApiResponse(
    @Schema(description = "공연 티켓팅 24 시간 전")
    boolean canReserve24,

    @Schema(description = "공연 티켓팅 6 시간 전")
    boolean canReserve6,

    @Schema(description = "공연 티켓팅 1 시간 전")
    boolean canReserve1
) {

    public static TicketingAlertReservationAvailabilityApiResponse from(
        TicketingAlertReservationAvailabilityServiceResponse response
    ) {
        return TicketingAlertReservationAvailabilityApiResponse.builder()
            .canReserve24(response.canReserve24())
            .canReserve6(response.canReserve6())
            .canReserve1(response.canReserve1())
            .build();
    }
}
