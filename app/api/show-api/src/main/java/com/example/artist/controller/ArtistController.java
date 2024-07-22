package com.example.artist.controller;

import com.example.artist.controller.dto.request.ArtistPaginationApiRequest;
import com.example.artist.controller.dto.request.ArtistSubscriptionApiRequest;
import com.example.artist.controller.dto.request.ArtistUnsubscriptionApiRequest;
import com.example.artist.controller.dto.response.ArtistPaginationApiResponse;
import com.example.artist.controller.dto.response.ArtistSearchApiResponse;
import com.example.artist.controller.dto.response.ArtistSimpleApiResponse;
import com.example.artist.service.ArtistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.security.dto.AuthenticatedUser;
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

    @PostMapping("/subscribe")
    @Operation(summary = "구독하기")
    public ResponseEntity<Void> bulkSubscribe(
        @Valid @RequestBody ArtistSubscriptionApiRequest request
    ) {
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/unsubscribe")
    @Operation(summary = "구독 취소하기")
    public ResponseEntity<Void> unsubscribe(
        @Valid @RequestBody ArtistUnsubscriptionApiRequest request
    ) {
        return ResponseEntity.noContent().build();
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
