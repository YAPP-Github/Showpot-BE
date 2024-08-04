package com.example.show.controller;

import com.example.artist.controller.dto.response.ArtistSimpleApiResponse;
import com.example.genre.controller.dto.response.GenreSimpleApiResponse;
import com.example.show.controller.dto.param.ShowSearchPaginationApiParam;
import com.example.show.controller.dto.request.ShowAlertRegistrationApiRequest;
import com.example.show.controller.dto.request.ShowInterestPaginationApiRequest;
import com.example.show.controller.dto.request.ShowSearchPaginationApiRequest;
import com.example.show.controller.dto.response.ShowAlertPaginationApiResponse;
import com.example.show.controller.dto.response.ShowDetailApiResponse;
import com.example.show.controller.dto.response.ShowInterestApiResponse;
import com.example.show.controller.dto.response.ShowInterestPaginationApiResponse;
import com.example.show.controller.dto.response.ShowPaginationApiResponse;
import com.example.show.controller.dto.response.ShowSimpleApiResponse;
import com.example.show.controller.dto.response.TicketingAndShowInfoApiResponse;
import com.example.show.service.ShowService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.PaginationApiResponse;
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
    public ResponseEntity<ShowPaginationApiResponse> getShows(
        @RequestParam(required = false) ShowSearchPaginationApiRequest param
    ) {
        return ResponseEntity.ok(
            new ShowPaginationApiResponse(
                List.of(
                    new ShowSimpleApiResponse(
                        UUID.randomUUID(),
                        "2021 서울재즈페스티벌",
                        new ArtistSimpleApiResponse(
                            UUID.randomUUID(),
                            "윈터",
                            image
                        ),
                        new GenreSimpleApiResponse(
                            UUID.randomUUID(),
                            "재즈",
                            image
                        ),
                        List.of(
                            new TicketingAndShowInfoApiResponse(
                                "2021-10-01 14:00:00",
                                "2021-10-03 14:00:00",
                                image
                            )
                        ),
                        image
                    )
                ),
                false
            )
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
            new ShowInterestPaginationApiResponse(
                List.of(
                    new ShowSimpleApiResponse(
                        UUID.randomUUID(),
                        "2021 서울재즈페스티벌",
                        new ArtistSimpleApiResponse(
                            UUID.randomUUID(),
                            "윈터",
                            image
                        ),
                        new GenreSimpleApiResponse(
                            UUID.randomUUID(),
                            "재즈",
                            image
                        ),
                        List.of(
                            new TicketingAndShowInfoApiResponse(
                                "2021-10-01 14:00:00",
                                "2021-10-03 14:00:00",
                                image
                            )
                        ),
                        image
                    )
                ),
                false
            )
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
            new ShowAlertPaginationApiResponse(
                List.of(
                    new ShowSimpleApiResponse(
                        UUID.randomUUID(),
                        "2021 서울재즈페스티벌",
                        new ArtistSimpleApiResponse(
                            UUID.randomUUID(),
                            "윈터",
                            image
                        ),
                        new GenreSimpleApiResponse(
                            UUID.randomUUID(),
                            "재즈",
                            image
                        ),
                        List.of(
                            new TicketingAndShowInfoApiResponse(
                                "2021-10-01 14:00:00",
                                "2021-10-03 14:00:00",
                                image
                            )
                        ),
                        image
                    )
                ),
                false
            )
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
