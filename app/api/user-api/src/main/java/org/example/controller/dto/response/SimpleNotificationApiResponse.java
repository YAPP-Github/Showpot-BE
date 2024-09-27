package org.example.controller.dto.response;

import java.util.UUID;
import lombok.Builder;

@Builder
public record SimpleNotificationApiResponse(
    String title,
    String message,
    String notifiedAt,
    UUID showId,
    String showImageURL
) {

}
