package com.example.show.controller.dto.param;

import com.example.show.service.dto.param.ShowTicketingSiteInfoServiceParam;
import lombok.Builder;

@Builder
public record ShowTicketingSiteInfoApiParam(
    String ticketingSiteName,
    String ticketingSiteUrl
) {

    public static ShowTicketingSiteInfoApiParam from(ShowTicketingSiteInfoServiceParam param) {
        return ShowTicketingSiteInfoApiParam.builder()
            .ticketingSiteName(param.ticketingSiteName())
            .ticketingSiteName(param.ticketingSiteUrl())
            .build();
    }
}
