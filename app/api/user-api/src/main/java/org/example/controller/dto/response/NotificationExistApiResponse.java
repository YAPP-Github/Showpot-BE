package org.example.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.example.service.dto.response.NotificationExistServiceResponse;

@Builder
public record NotificationExistApiResponse(
    @Schema(description = "미열람 존재 여부")
    boolean isExist
) {

    public static NotificationExistApiResponse from(NotificationExistServiceResponse response) {
        return new NotificationExistApiResponse(response.isActivate());
    }
}
