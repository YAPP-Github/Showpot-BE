package com.example.genre.controller;

import com.example.genre.controller.dto.param.GenrePaginationApiParam;
import com.example.genre.controller.dto.param.GenreSubscriptionPaginationApiParam;
import com.example.genre.controller.dto.param.GenreUnsubscriptionPaginationApiParam;
import com.example.genre.controller.dto.request.GenrePaginationApiRequest;
import com.example.genre.controller.dto.request.GenreSubscriptionApiRequest;
import com.example.genre.controller.dto.request.GenreSubscriptionPaginationApiRequest;
import com.example.genre.controller.dto.request.GenreUnsubscriptionApiRequest;
import com.example.genre.controller.dto.request.GenreUnsubscriptionPaginationApiRequest;
import com.example.genre.controller.dto.response.GenreSubscriptionApiResponse;
import com.example.genre.controller.dto.response.GenreUnsubscriptionApiResponse;
import com.example.genre.controller.dto.response.NumberOfSubscribedGenreApiResponse;
import com.example.genre.service.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.PaginationApiResponse;
import org.example.security.dto.AuthenticatedInfo;
import org.example.util.ValidatorUser;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/genres")
@Tag(name = "장르")
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    @Operation(summary = "장르 전체 목록 조회")
    public ResponseEntity<PaginationApiResponse<GenrePaginationApiParam>> getGenres(
        @AuthenticationPrincipal AuthenticatedInfo user,
        @ParameterObject GenrePaginationApiRequest request
    ) {
        UUID userId = ValidatorUser.getUserId(user);
        var response = genreService.findGenres(request.toServiceRequest(userId));
        var data = response.data().stream()
            .map(GenrePaginationApiParam::new)
            .toList();

        return ResponseEntity.ok(
            PaginationApiResponse.<GenrePaginationApiParam>builder()
                .hasNext(response.hasNext())
                .data(data)
                .build()
        );
    }

    @GetMapping("/unsubscriptions")
    @Operation(summary = "구독하지 않은 장르 목록 조회")
    public ResponseEntity<PaginationApiResponse<GenreUnsubscriptionPaginationApiParam>> getUnsubscribedGenres(
        @AuthenticationPrincipal AuthenticatedInfo user,
        @ParameterObject GenreUnsubscriptionPaginationApiRequest request
    ) {
        var response = genreService.findGenreUnSubscriptions(
            request.toServiceRequest(user.userId()));
        var data = response.data().stream()
            .map(GenreUnsubscriptionPaginationApiParam::new)
            .toList();

        return ResponseEntity.ok(
            PaginationApiResponse.<GenreUnsubscriptionPaginationApiParam>builder()
                .hasNext(response.hasNext())
                .data(data)
                .build()
        );
    }

    @GetMapping("/subscriptions")
    @Operation(summary = "구독한 장르 목록 조회")
    public ResponseEntity<PaginationApiResponse<GenreSubscriptionPaginationApiParam>> getSubscribedGenres(
        @AuthenticationPrincipal AuthenticatedInfo user,
        @ParameterObject GenreSubscriptionPaginationApiRequest request
    ) {
        var response = genreService.findGenreSubscriptions(request.toServiceRequest(user.userId()));
        var data = response.data().stream()
            .map(GenreSubscriptionPaginationApiParam::new)
            .toList();

        return ResponseEntity.ok(
            PaginationApiResponse.<GenreSubscriptionPaginationApiParam>builder()
                .hasNext(response.hasNext())
                .data(data)
                .build()
        );
    }

    @GetMapping("/subscriptions/count")
    @Operation(summary = "구독한 장르 수")
    public ResponseEntity<NumberOfSubscribedGenreApiResponse> getNumberOfSubscribedGenre(
        @AuthenticationPrincipal AuthenticatedInfo user
    ) {
        return ResponseEntity.ok(
            NumberOfSubscribedGenreApiResponse.from(
                genreService.countSubscribedGenres(user.userId())
            )
        );
    }

    @PostMapping("/subscribe")
    @Operation(summary = "구독하기")
    public ResponseEntity<GenreSubscriptionApiResponse> subscribe(
        @AuthenticationPrincipal AuthenticatedInfo user,
        @Valid @RequestBody GenreSubscriptionApiRequest request
    ) {
        return ResponseEntity.ok(
            GenreSubscriptionApiResponse.from(
                genreService.subscribe(request.toServiceRequest(user.userId()))
            )
        );
    }

    @PostMapping("/unsubscribe")
    @Operation(summary = "구독 취소하기")
    public ResponseEntity<GenreUnsubscriptionApiResponse> unsubscribe(
        @AuthenticationPrincipal AuthenticatedInfo user,
        @Valid @RequestBody GenreUnsubscriptionApiRequest request
    ) {
        return ResponseEntity.ok(
            GenreUnsubscriptionApiResponse.from(
                genreService.unsubscribe(request.toServiceRequest(user.userId()))
            )
        );
    }
}
