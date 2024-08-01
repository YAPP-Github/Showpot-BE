package com.example.show.service.dto.param;

import lombok.Builder;

@Builder
public record ShowTicketingSiteInfoServiceParam(
    String ticketingSiteName,
    String ticketingSiteUrl
) {

    public static ShowTicketingSiteInfoServiceParam from(String ticketingSiteName, String ticketingSiteUrl) {
        return ShowTicketingSiteInfoServiceParam.builder()
            .ticketingSiteName(ticketingSiteName)
            .ticketingSiteUrl(ticketingSiteUrl)
            .build();
    }
}
