package org.example.controller.dto.param;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import lombok.Builder;

@Builder
public record SimpleNotificationApiParam(
    @Schema(description = "알림 제목")
    String title,
    @Schema(description = "알림 본문")
    String message,
    @Schema(description = "알림 시간")
    String notifiedAt,
    @Schema(description = "공연 ID")
    UUID showId,
    @Schema(description = "공연 이미지 URL")
    String showImageURL
) {

}
