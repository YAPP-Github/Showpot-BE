package com.example.show.controller;

import com.example.show.controller.dto.param.ShowSearchPaginationApiParam;
import com.example.show.controller.dto.request.ShowPaginationApiRequest;
import com.example.show.controller.dto.request.ShowSearchPaginationApiRequest;
import com.example.show.controller.dto.response.ShowDetailApiResponse;
import com.example.show.controller.dto.response.ShowPaginationApiParam;
import com.example.show.service.ShowService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.PaginationApiResponse;
import org.example.security.dto.AuthenticatedInfo;
import org.example.util.ValidatorUser;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shows")
@Tag(name = "공연")
public class ShowController {

    private final ShowService showService;

    @GetMapping
    @Operation(summary = "공연 목록 조회")
    public ResponseEntity<PaginationApiResponse<ShowPaginationApiParam>> getShows(
        @Valid @ParameterObject ShowPaginationApiRequest request,
        @RequestParam(defaultValue = "30") @Max(value = 30, message = "조회하는 데이터 개수는 최대 30개 이어야 합니다.") int size
    ) {
        var response = showService.findShows(request.toServiceRequest(size));
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

    @GetMapping("/{showId}")
    @Operation(summary = "공연 상세 조회")
    public ResponseEntity<ShowDetailApiResponse> getShow(
        @AuthenticationPrincipal AuthenticatedInfo info,
        @PathVariable("showId") UUID showId,
        @RequestHeader(value = "Device-Token") String deviceToken
    ) {
        UUID userId = ValidatorUser.getUserId(info);

        return ResponseEntity.ok(
            ShowDetailApiResponse.from(showService.getShow(userId, showId, deviceToken))
        );
    }

    @GetMapping("/search")
    @Operation(summary = "검색하기")
    public ResponseEntity<PaginationApiResponse<ShowSearchPaginationApiParam>> search(
        @ParameterObject ShowSearchPaginationApiRequest request,
        @RequestParam(defaultValue = "30") @Max(value = 30, message = "조회하는 데이터 개수는 최대 30개 이어야 합니다.") int size
    ) {
        var response = showService.searchShow(request.toServiceRequest(size));

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
