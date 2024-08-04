package com.example.show.service.dto.param;

import lombok.Builder;

@Builder
public record ShowTicketingSiteServiceParam(
    String siteName,
    String siteURL
) {

}
