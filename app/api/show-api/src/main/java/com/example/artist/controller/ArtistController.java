package com.example.artist.controller;

import com.example.artist.controller.dto.param.ArtistSubscriptionPaginationApiParam;
import com.example.artist.controller.dto.request.ArtistPaginationApiRequest;
import com.example.artist.controller.dto.request.ArtistSubscriptionApiRequest;
import com.example.artist.controller.dto.request.ArtistSubscriptionPaginationApiRequest;
import com.example.artist.controller.dto.request.ArtistUnsubscriptionApiRequest;
import com.example.artist.controller.dto.response.ArtistPaginationApiResponse;
import com.example.artist.controller.dto.response.ArtistSearchApiResponse;
import com.example.artist.controller.dto.response.ArtistSimpleApiResponse;
import com.example.artist.controller.dto.response.ArtistSubscriptionApiResponse;
import com.example.artist.controller.dto.response.ArtistUnsubscriptionApiResponse;
import com.example.artist.service.ArtistService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/artists")
@Tag(name = "아티스트")
public class ArtistController {

    private final ArtistService artistService;
    private String image = "https://thumb.mtstarnews.com/06/2023/06/2023062914274537673_1.jpg";

    @GetMapping
    @Operation(summary = "아티스트 목록 조회")
    public ResponseEntity<ArtistPaginationApiResponse> getArtists(
        @RequestParam(required = false) ArtistPaginationApiRequest param
    ) {
        return ResponseEntity.ok(
            new ArtistPaginationApiResponse(
                List.of(
                    new ArtistSimpleApiResponse(
                        UUID.randomUUID(),
                        "윈터",
                        image
                    )
                ),
                false
            )
        );
    }

    @GetMapping("/subscriptions")
    @Operation(summary = "구독한 아티스트 목록 조회")
    public ResponseEntity<PaginationApiResponse<ArtistSubscriptionPaginationApiParam>> getSubscribedArtists(
        @AuthenticationPrincipal AuthenticatedUser user,
        @ParameterObject ArtistSubscriptionPaginationApiRequest request
    ) {
        var response = artistService.findArtistSubscriptions(request.toServiceRequest(user.userId()));
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
    public ResponseEntity<ArtistSearchApiResponse> search(
        @AuthenticationPrincipal AuthenticatedUser user,
        @RequestParam(value = "name") String name
    ) {
        ArtistSearchApiResponse artistSearchApiResponse = new ArtistSearchApiResponse(
            artistService.searchArtist(name));

        return ResponseEntity.ok(artistSearchApiResponse);
    }
}
