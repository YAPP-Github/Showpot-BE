package com.example.artist.controller;

import com.example.artist.controller.dto.param.ArtistSearchPaginationApiParam;
import com.example.artist.controller.dto.param.ArtistSubscriptionPaginationApiParam;
import com.example.artist.controller.dto.param.ArtistUnsubscriptionPaginationApiParam;
import com.example.artist.controller.dto.request.ArtistSearchPaginationApiRequest;
import com.example.artist.controller.dto.request.ArtistSubscriptionApiRequest;
import com.example.artist.controller.dto.request.ArtistSubscriptionPaginationApiRequest;
import com.example.artist.controller.dto.request.ArtistUnsubscriptionApiRequest;
import com.example.artist.controller.dto.request.ArtistUnsubscriptionPaginationApiRequest;
import com.example.artist.controller.dto.response.ArtistSubscriptionApiResponse;
import com.example.artist.controller.dto.response.ArtistUnsubscriptionApiResponse;
import com.example.artist.service.ArtistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.PaginationApiResponse;
import org.example.security.dto.AuthenticatedUser;
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
@RequestMapping("/api/v1/artists")
@Tag(name = "아티스트")
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping
    @Operation(summary = "구독하지 않은 아티스트 목록 조회")
    public ResponseEntity<PaginationApiResponse<ArtistUnsubscriptionPaginationApiParam>> getUnsubscribedArtists(
        @AuthenticationPrincipal AuthenticatedUser user,
        @ParameterObject ArtistUnsubscriptionPaginationApiRequest request
    ) {
        var response = artistService.findArtistUnsubscriptions(
            request.toServiceRequest(user.userId()));
        var data = response.data().stream()
            .map(ArtistUnsubscriptionPaginationApiParam::from)
            .toList();

        return ResponseEntity.ok(
            PaginationApiResponse.<ArtistUnsubscriptionPaginationApiParam>builder()
                .hasNext(response.hasNext())
                .data(data)
                .build()
        );
    }

    @GetMapping("/subscriptions")
    @Operation(summary = "구독한 아티스트 목록 조회")
    public ResponseEntity<PaginationApiResponse<ArtistSubscriptionPaginationApiParam>> getSubscribedArtists(
        @AuthenticationPrincipal AuthenticatedUser user,
        @ParameterObject ArtistSubscriptionPaginationApiRequest request
    ) {
        var response = artistService.findArtistSubscriptions(
            request.toServiceRequest(user.userId()));
        var data = response.data().stream()
            .map(ArtistSubscriptionPaginationApiParam::from)
            .toList();

        return ResponseEntity.ok(
            PaginationApiResponse.<ArtistSubscriptionPaginationApiParam>builder()
                .hasNext(response.hasNext())
                .data(data)
                .build()
        );
    }

    @PostMapping("/subscribe")
    @Operation(summary = "구독하기")
    public ResponseEntity<ArtistSubscriptionApiResponse> subscribe(
        @AuthenticationPrincipal AuthenticatedUser user,
        @Valid @RequestBody ArtistSubscriptionApiRequest request
    ) {
        return ResponseEntity.ok(
            ArtistSubscriptionApiResponse.from(
                artistService.subscribe(request.toServiceRequest(user.userId()))
            )
        );
    }

    @PostMapping("/unsubscribe")
    @Operation(summary = "구독 취소하기")
    public ResponseEntity<ArtistUnsubscriptionApiResponse> unsubscribe(
        @AuthenticationPrincipal AuthenticatedUser user,
        @Valid @RequestBody ArtistUnsubscriptionApiRequest request
    ) {
        ;
        return ResponseEntity.ok(
            ArtistUnsubscriptionApiResponse.from(
                artistService.unsubscribe(request.toServiceRequest(user.userId()))
            )
        );
    }

    @GetMapping("/search")
    @Operation(summary = "검색하기")
    public ResponseEntity<PaginationApiResponse<ArtistSearchPaginationApiParam>> search(
        @AuthenticationPrincipal AuthenticatedUser user,
        @ParameterObject ArtistSearchPaginationApiRequest request
    ) {
        var response = artistService.searchArtist(request.toServiceRequest());
        var data = response.data().stream()
            .map(ArtistSearchPaginationApiParam::from)
            .toList();

        return ResponseEntity.ok(
            PaginationApiResponse.<ArtistSearchPaginationApiParam>builder()
                .hasNext(response.hasNext())
                .data(data)
                .build()
        );
    }
}
