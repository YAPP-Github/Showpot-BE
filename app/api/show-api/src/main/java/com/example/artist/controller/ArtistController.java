package com.example.artist.controller;

import com.example.artist.controller.dto.request.ArtistPaginationApiRequest;
import com.example.artist.controller.dto.request.ArtistSubscriptionApiRequest;
import com.example.artist.controller.dto.request.ArtistUnsubscriptionApiRequest;
import com.example.artist.controller.dto.response.ArtistPaginationApiResponse;
import com.example.artist.controller.dto.response.ArtistSimpleApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
                        "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyNDAxMDhfODMg%2FMDAxNzA0Njg0MzE0NTIx.ZqpnCpmoZ6PxldRyHqsHT3G2TDLQSTQv2ZWYPMDPevkg.kd3AS2NbaMWAOoA0iXgyBZHTWxOg7NO61SYnvkkydFkg.JPEG.jphair22%2F%25C0%25A9%25C5%25CD%25B4%25DC%25B9%25DF2.jpg&type=a340"
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
}
