package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.controller.dto.param.SimpleNotificationApiParam;
import org.example.controller.dto.response.NotificationExistApiResponse;
import org.example.dto.response.PaginationApiResponse;
import org.example.security.dto.AuthenticatedInfo;
import org.example.service.UserAlarmService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "유저 알림")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserAlarmController {

    private final UserAlarmService userAlarmService;

    @GetMapping("/notifications/exist")
    @Operation(summary = "알림 미열람 존재 여부")
    public ResponseEntity<NotificationExistApiResponse> hasUnreadNotifications(
        @AuthenticationPrincipal AuthenticatedInfo info
    ) {
        var response = userAlarmService.getNotificationExist(info.userId());

        return ResponseEntity.ok(
            NotificationExistApiResponse.from(response)
        );
    }

    @GetMapping("/notifications")
    @Operation(summary = "알림 목록")
    public ResponseEntity<PaginationApiResponse<SimpleNotificationApiParam>> getNotifications(
        @RequestParam(value = "cursorId", required = false) UUID cursorId,
        @RequestParam(value = "size") @Max(value = 30, message = "조회하는 데이터의 최대 개수는 30입니다.")
        Integer size,
        @AuthenticationPrincipal AuthenticatedInfo info

    ) {
        var response = userAlarmService.findNotifications(info.userId(), cursorId, size);
        var data = response.data().stream()
            .map(SimpleNotificationApiParam::from)
            .toList();

        return ResponseEntity.ok(
            PaginationApiResponse.<SimpleNotificationApiParam>builder()
                .hasNext(response.hasNext())
                .data(data)
                .cursor(response.cursor())
                .build()
        );
    }
}
