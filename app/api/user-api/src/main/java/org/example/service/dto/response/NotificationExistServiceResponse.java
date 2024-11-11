package org.example.service.dto.response;

import lombok.Builder;

@Builder
public record NotificationExistServiceResponse(
    boolean isActivate
) {

}
