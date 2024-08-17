package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.example.controller.dto.response.TicketingAlertCountApiResponse;
import org.example.security.dto.AuthenticatedUser;
import org.example.service.UserShowService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Tag(name = "유저 공연")
public class UserShowController {

    private final UserShowService userShowService;

    @GetMapping("/shows/alerts/count")
    @Operation(summary = "알림 설정한 공연 개수 조회")
    public TicketingAlertCountApiResponse getAlertShowCount(
        @AuthenticationPrincipal AuthenticatedUser user
    ) {
        LocalDateTime now = LocalDateTime.now();
        return TicketingAlertCountApiResponse.from(
            userShowService.countAlertShows(user.userId(), now)
        );
    }
}
