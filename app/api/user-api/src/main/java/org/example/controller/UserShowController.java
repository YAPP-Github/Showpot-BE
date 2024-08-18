package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.example.controller.dto.response.NumberOfSubscribedArtistApiResponse;
import org.example.controller.dto.response.NumberOfSubscribedGenreApiResponse;
import org.example.controller.dto.response.NumberOfTicketingAlertApiResponse;
import org.example.security.dto.AuthenticatedUser;
import org.example.service.UserShowService;
import org.springframework.http.ResponseEntity;
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
    @Operation(summary = "알림 설정한 공연 개수")
    public ResponseEntity<NumberOfTicketingAlertApiResponse> getNumberOfAlertShow(
        @AuthenticationPrincipal AuthenticatedUser user
    ) {
        LocalDateTime now = LocalDateTime.now();
        return ResponseEntity.ok(
            NumberOfTicketingAlertApiResponse.from(
                userShowService.countAlertShows(user.userId(), now)
            )
        );
    }

    @GetMapping("/artists/subscriptions/count")
    @Operation(summary = "구독한 아티스트 수")
    public ResponseEntity<NumberOfSubscribedArtistApiResponse> getNumberOfSubscribedArtist(
        @AuthenticationPrincipal AuthenticatedUser user
    ) {
        return ResponseEntity.ok(
            NumberOfSubscribedArtistApiResponse.from(
                userShowService.countSubscribedArtists(user.userId())
            )
        );
    }

    @GetMapping("/genres/subscriptions/count")
    @Operation(summary = "구독한 장르 수")
    public ResponseEntity<NumberOfSubscribedGenreApiResponse> getNumberOfSubscribedGenre(
        @AuthenticationPrincipal AuthenticatedUser user
    ) {
        return ResponseEntity.ok(
            NumberOfSubscribedGenreApiResponse.from(
                userShowService.countSubscribedGenres(user.userId())
            )
        );
    }
}
