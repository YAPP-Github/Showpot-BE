package com.example.show.controller;

import com.example.show.controller.dto.param.ShowSearchPaginationApiParam;
import com.example.show.controller.dto.request.ShowAlertRegistrationApiRequest;
import com.example.show.controller.dto.request.ShowInterestPaginationApiRequest;
import com.example.show.controller.dto.request.ShowPaginationApiRequest;
import com.example.show.controller.dto.request.ShowSearchPaginationApiRequest;
import com.example.show.controller.dto.response.ShowAlertPaginationApiResponse;
import com.example.show.controller.dto.response.ShowDetailApiResponse;
import com.example.show.controller.dto.response.ShowInterestApiResponse;
import com.example.show.controller.dto.response.ShowInterestPaginationApiResponse;
import com.example.show.controller.dto.response.ShowPaginationApiParam;
import com.example.show.service.ShowService;
import com.example.show.service.dto.response.ShowPaginationServiceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.PaginationApiResponse;
import org.example.dto.response.PaginationServiceResponse;
import org.example.security.dto.AuthenticatedUser;
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
public class ShowController {

    private final ShowService showService;

    private String image = "https://thumb.mtstarnews.com/06/2023/06/2023062914274537673_1.jpg";

    @GetMapping
    @Operation(summary = "공연 목록 조회")
    public ResponseEntity<PaginationApiResponse<ShowPaginationApiParam>> getShows(
        @RequestParam(required = false) ShowPaginationApiRequest request
    ) {
        PaginationServiceResponse<ShowPaginationServiceResponse> response = showService.findShows(
            request.toServiceRequest()
        );

        var data = response.data().stream()
            .map(ShowPaginationApiParam::from)
            .toList();

        return ResponseEntity.ok(
            PaginationApiResponse.<ShowPaginationApiParam>builder()
                 .data(data)
                 .hasNext(response.hasNext())
                .build()
        );

    }

    @PostMapping("/{showId}/interest")
    @Operation(summary = "공연 관심 등록 / 취소")
    public ResponseEntity<ShowInterestApiResponse> interest(
        @PathVariable("showId") UUID showId
    ) {
        return ResponseEntity.ok(
            new ShowInterestApiResponse(true)
        );
    }

    @GetMapping("/interests")
    @Operation(summary = "공연 관심 목록 조회")
    public ResponseEntity<ShowInterestPaginationApiResponse> getInterests(
        @RequestParam(required = false) ShowInterestPaginationApiRequest param
    ) {
        return ResponseEntity.ok(
            ShowInterestPaginationApiResponse.builder().build()
        );
    }

    @GetMapping("/{showId}")
    @Operation(summary = "공연 상세 조회")
    public ResponseEntity<ShowDetailApiResponse> getShow(
        @PathVariable("showId") UUID showId
    ) {
        return ResponseEntity.ok(
            ShowDetailApiResponse.from(showService.getShow(showId))
        );
    }

    @PostMapping("/{showId}/alert")
    @Operation(
        summary = "공연 알림 등록 / 취소",
        description = "요청한 알람 시간으로 기존 내용을 덮어쓴다."
    )
    public ResponseEntity<Void> alert(
        @PathVariable("showId") UUID showId,
        @Valid @RequestBody ShowAlertRegistrationApiRequest request
    ) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/alerts")
    @Operation(summary = "공연 알림 목록 조회")
    public ResponseEntity<ShowAlertPaginationApiResponse> getAlerts(
        @RequestParam(required = false) ShowInterestPaginationApiRequest param
    ) {
        return ResponseEntity.ok(
            ShowAlertPaginationApiResponse.builder().build()
        );
    }

    @GetMapping("/search")
    @Operation(summary = "검색하기")
    public ResponseEntity<PaginationApiResponse<ShowSearchPaginationApiParam>> search(
        @AuthenticationPrincipal AuthenticatedUser user,
        @ParameterObject ShowSearchPaginationApiRequest request
    ) {
        var response = showService.searchShow(request.toServiceRequest());

        var data = response.data().stream()
            .map(ShowSearchPaginationApiParam::from)
            .toList();

        return ResponseEntity.ok(
            PaginationApiResponse.<ShowSearchPaginationApiParam>builder()
                .hasNext(response.hasNext())
                .data(data)
                .build()
        );
    }
}
