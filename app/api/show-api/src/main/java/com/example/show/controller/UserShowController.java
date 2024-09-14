package com.example.show.controller;

import com.example.show.controller.dto.param.ShowAlertPaginationApiParam;
import com.example.show.controller.dto.request.ShowAlertPaginationApiRequest;
import com.example.show.controller.dto.request.ShowInterestPaginationApiRequest;
import com.example.show.controller.dto.request.TicketingAlertReservationApiRequest;
import com.example.show.controller.dto.response.InterestShowPaginationApiResponse;
import com.example.show.controller.dto.response.TerminatedTicketingShowCountApiResponse;
import com.example.show.controller.dto.response.TicketingAlertReservationApiResponse;
import com.example.show.controller.dto.usershow.response.NumberOfInterestShowApiResponse;
import com.example.show.controller.dto.usershow.response.NumberOfTicketingAlertApiResponse;
import com.example.show.controller.vo.TicketingApiType;
import com.example.show.service.UserShowService;
import com.example.show.service.dto.request.ShowInterestServiceRequest;
import com.example.show.service.dto.request.ShowUninterestedServiceRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.PaginationApiResponse;
import org.example.security.dto.AuthenticatedInfo;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shows")
@Tag(name = "공연")
public class UserShowController {

    private final UserShowService userShowService;

    @PostMapping("/{showId}/interests")
    @Operation(summary = "공연 관심 등록")
    public ResponseEntity<Void> interest(
        @PathVariable("showId") UUID showId,
        @AuthenticationPrincipal AuthenticatedInfo info
    ) {
        userShowService.interest(
            ShowInterestServiceRequest.builder()
                .showId(showId)
                .userId(info.userId())
                .build()
        );
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{showId}/uninterested")
    @Operation(summary = "공연 관심 취소")
    public ResponseEntity<Void> uninterested(
        @PathVariable("showId") UUID showId,
        @AuthenticationPrincipal AuthenticatedInfo info
    ) {
        userShowService.notInterest(
            ShowUninterestedServiceRequest.builder()
                .showId(showId)
                .userId(info.userId())
                .build()
        );
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/interests")
    @Operation(summary = "공연 관심 목록 조회")
    public ResponseEntity<PaginationApiResponse<InterestShowPaginationApiResponse>> getInterests(
        @AuthenticationPrincipal AuthenticatedInfo info,
        @Valid @ParameterObject ShowInterestPaginationApiRequest request
    ) {
        var serviceResponse = userShowService.findInterestShows(
            request.toServiceRequest(info.userId())
        );

        List<InterestShowPaginationApiResponse> response = serviceResponse.data().stream()
            .map(InterestShowPaginationApiResponse::from)
            .toList();

        return ResponseEntity.ok(
            PaginationApiResponse.<InterestShowPaginationApiResponse>builder()
                .data(response)
                .hasNext(serviceResponse.hasNext())
                .build()
        );
    }

    @GetMapping("/interests/count")
    @Operation(summary = "관심 공연 개수")
    public ResponseEntity<NumberOfInterestShowApiResponse> getNumberOfInterestShow(
        @AuthenticationPrincipal AuthenticatedInfo info
    ) {
        return ResponseEntity.ok(
            NumberOfInterestShowApiResponse.from(
                userShowService.countInterestShows(info.userId())
            )
        );
    }

    @PostMapping("/{showId}/alert")
    @Operation(
        summary = "공연 티켓팅 알림 등록 / 취소",
        description = "요청한 알람 시간으로 기존 내용을 덮어쓴다."
    )
    public ResponseEntity<Void> alert(
        @AuthenticationPrincipal AuthenticatedInfo info,
        @PathVariable("showId") UUID showId,
        @RequestParam("ticketingApiType") TicketingApiType type,
        @Valid @RequestBody TicketingAlertReservationApiRequest ticketingAlertReservationRequest
    ) {
        userShowService.alertReservation(
            ticketingAlertReservationRequest.toServiceRequest(info.userId(), showId, type)
        );

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/alerts")
    @Operation(summary = "공연 알림 목록 조회")
    public ResponseEntity<PaginationApiResponse<ShowAlertPaginationApiParam>> getAlerts(
        @AuthenticationPrincipal AuthenticatedInfo info,
        @Valid @ParameterObject ShowAlertPaginationApiRequest request
    ) {
        var alertShows = userShowService.findAlertShows(
            request.toServiceRequest(info.userId())
        );
        var showAlertPaginationApiParams = alertShows.data().stream()
            .map(ShowAlertPaginationApiParam::from)
            .toList();

        return ResponseEntity.ok(
            PaginationApiResponse.<ShowAlertPaginationApiParam>builder()
                .data(showAlertPaginationApiParams)
                .hasNext(alertShows.hasNext())
                .build()
        );
    }

    @GetMapping("/{showId}/alert/reservations")
    @Operation(summary = "공연 티켓팅 알림 예약 조회")
    public ResponseEntity<TicketingAlertReservationApiResponse> getAlertsReservations(
        @AuthenticationPrincipal AuthenticatedInfo info,
        @PathVariable("showId") UUID showId,
        @RequestParam("ticketingApiType") TicketingApiType type
    ) {
        var now = LocalDateTime.now();
        return ResponseEntity.ok(
            TicketingAlertReservationApiResponse.from(
                userShowService.findAlertsReservations(info.userId(), showId, type, now)
            )
        );
    }

    @GetMapping("/alerts/count")
    @Operation(summary = "알림 설정한 공연 개수")
    public ResponseEntity<NumberOfTicketingAlertApiResponse> getNumberOfAlertShow(
        @AuthenticationPrincipal AuthenticatedInfo info
    ) {
        LocalDateTime now = LocalDateTime.now();
        return ResponseEntity.ok(
            NumberOfTicketingAlertApiResponse.from(
                userShowService.countAlertShows(info.userId(), now)
            )
        );
    }

    @GetMapping("/terminated/ticketing/count")
    @Operation(summary = "티켓팅 알림 설정 후 공연이 종료된 개수")
    public ResponseEntity<TerminatedTicketingShowCountApiResponse> getNumberOfTerminatedTicketingShowCount(
        @AuthenticationPrincipal AuthenticatedInfo info
    ) {
        return ResponseEntity.ok(
            TerminatedTicketingShowCountApiResponse.from(
                userShowService.countTerminatedTicketingShow(info.userId())
            )
        );
    }
}
