package org.example.controller.dto.response;

import java.util.List;
import lombok.Builder;
import org.example.controller.dto.param.SimpleNotificationApiParam;

@Builder
public record NotificationsApiResponse(
    List<SimpleNotificationApiParam> notifications
) {

}
