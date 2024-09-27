package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.controller.dto.response.HasUnreadNotificationApiResponse;
import org.example.security.dto.AuthenticatedInfo;
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
    public ResponseEntity<Void> getNotifications(
        @AuthenticationPrincipal AuthenticatedInfo info
    ) {
        return ResponseEntity.noContent().build();
    }
}
