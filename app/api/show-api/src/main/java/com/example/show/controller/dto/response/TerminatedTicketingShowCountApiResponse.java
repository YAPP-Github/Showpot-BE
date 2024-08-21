package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.TerminatedTicketingShowCountServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;

public record TerminatedTicketingShowCountApiResponse(
    @Schema(description = "개수")
    long count
) {

    public static TerminatedTicketingShowCountApiResponse from(
        TerminatedTicketingShowCountServiceResponse response
    ) {
        return new TerminatedTicketingShowCountApiResponse(response.count());
    }
}
