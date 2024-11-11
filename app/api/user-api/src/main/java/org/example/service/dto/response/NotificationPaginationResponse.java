package org.example.service.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.example.dto.response.CursorApiResponse;

public record NotificationPaginationResponse(
    int size,
    boolean hasNext,
    List<NotificationInfoResponse> data,
    CursorApiResponse cursor
) {

    public record NotificationInfoResponse(
        UUID id,
        UUID showId,
        String title,
        String content,
        LocalDateTime createAt
    ) {

    }

}
