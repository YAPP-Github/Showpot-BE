package com.example.show.controller.dto.request;

import com.example.show.controller.vo.TicketingAlertTimeApiType;
import com.example.show.controller.vo.TicketingApiType;
import com.example.show.service.dto.request.TicketingAlertReservationServiceRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;

public record TicketingAlertReservationApiRequest(

    @Schema(description = "공연 티켓팅 알림 시간 선택")
    List<TicketingAlertTimeApiType> alertTimes
) {

    public TicketingAlertReservationServiceRequest toServiceRequest(
        UUID userId,
        UUID showId,
        TicketingApiType type
    ) {
        return TicketingAlertReservationServiceRequest.builder()
            .userId(userId)
            .showId(showId)
            .type(type)
            .alertTimes(alertTimes)
            .build();
    }
}
