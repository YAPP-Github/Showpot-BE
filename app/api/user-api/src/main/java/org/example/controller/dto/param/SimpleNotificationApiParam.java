package org.example.controller.dto.param;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import lombok.Builder;
import org.example.service.dto.response.NotificationServiceResponse.NotificationInfoWithImageResponse;
import org.example.util.DateTimeUtil;

@Builder
public record SimpleNotificationApiParam(
    @Schema(description = "알림 제목")
    String title,

    @Schema(description = "알림 본문")
    String message,

    @Schema(description = "알림 생성 시간")
    String notifiedAt,

    @Schema(description = "공연 ID")
    UUID showId,

    @Schema(description = "공연 이미지 URL")
    String showImageURL
) {

    public static SimpleNotificationApiParam from(NotificationInfoWithImageResponse response) {
        return SimpleNotificationApiParam.builder()
            .title(response.title())
            .message(response.content())
            .notifiedAt(DateTimeUtil.formatDateTime(response.createAt()))
            .showId(response.showId())
            .showImageURL(response.imageURL())
            .build();
    }

}
