package com.example.show.controller.dto.param;

import com.example.show.service.dto.param.ShowTicketingSiteServiceParam;
import lombok.Builder;

@Builder
public record ShowTicketingSiteApiParam(
    String siteName,
    String siteURL
) {

    public static ShowTicketingSiteApiParam from(ShowTicketingSiteServiceParam param) {
        return ShowTicketingSiteApiParam.builder()
            .siteName(param.siteName())
            .siteURL(param.siteURL())
            .build();
    }
}
