package org.example.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record HasUnreadNotificationApiResponse(
    @Schema(description = "안 읽은 알림 존재 여부")
    boolean hasUnreadNotification
) {

}
