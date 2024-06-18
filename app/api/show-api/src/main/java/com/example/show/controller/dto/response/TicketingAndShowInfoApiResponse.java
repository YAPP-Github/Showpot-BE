package com.example.show.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record TicketingAndShowInfoApiResponse(

    @Schema(description = "티켓팅 시각")
    String ticketingDateTime,

    @Schema(description = "공연 시각")
    String showDateTime,

    @Schema(description = "티켓팅 링크")
    String ticketingURL
) {

}
