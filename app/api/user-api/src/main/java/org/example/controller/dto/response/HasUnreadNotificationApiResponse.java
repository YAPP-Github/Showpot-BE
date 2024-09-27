package org.example.controller.dto.response;

import lombok.Builder;

@Builder
public record HasUnreadNotificationApiResponse(
    boolean hasUnreadNotification
) {

}
