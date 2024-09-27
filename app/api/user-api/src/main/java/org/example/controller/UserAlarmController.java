package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.controller.dto.param.SimpleNotificationApiParam;
import org.example.controller.dto.response.HasUnreadNotificationApiResponse;
import org.example.controller.dto.response.NotificationsApiResponse;
import org.example.security.dto.AuthenticatedInfo;
import org.example.util.DateTimeUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "유저 알림")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserAlarmController {

    @GetMapping("/notifications/unread")
    @Operation(summary = "안 읽은 알림 존재 여부")
    public ResponseEntity<HasUnreadNotificationApiResponse> hasUnreadNotifications(
        @AuthenticationPrincipal AuthenticatedInfo info
    ) {
        return ResponseEntity.ok(
            HasUnreadNotificationApiResponse.builder()
                .hasUnreadNotification(true)
                .build()
        );
    }

    @GetMapping("/notifications")
    @Operation(summary = "알림 목록")
    public ResponseEntity<NotificationsApiResponse> getNotifications(
        @AuthenticationPrincipal AuthenticatedInfo info
    ) {
        return ResponseEntity.ok(
            NotificationsApiResponse.builder()
                .notifications(
                    List.of(
                        SimpleNotificationApiParam.builder()
                            .title("오하요 고자이마스")
                            .message("본문 데스")
                            .notifiedAt(DateTimeUtil.formatDateTime(LocalDateTime.of(2021, 9, 27, 0, 0, 0)))
                            .showId(java.util.UUID.randomUUID())
                            .showImageURL("https://example.com/show.jpg")
                            .build(),
                        SimpleNotificationApiParam.builder()
                            .title("알림알림제목제목알림알림제목제목")
                            .message("알림본문본문알림본문본문알림본문본문")
                            .notifiedAt(DateTimeUtil.formatDateTime(LocalDateTime.of(2021, 9, 27, 12, 0, 0)))
                            .showId(java.util.UUID.randomUUID())
                            .showImageURL("https://example.com/show.jpg")
                            .build(),
                        SimpleNotificationApiParam.builder()
                            .title("알림 제목")
                            .message("알림 본문")
                            .notifiedAt(DateTimeUtil.formatDateTime(LocalDateTime.of(2021, 9, 27, 23, 0, 0)))
                            .showId(java.util.UUID.randomUUID())
                            .showImageURL("https://example.com/show.jpg")
                            .build()
                    )
                )
                .build()
        );
    }
}
