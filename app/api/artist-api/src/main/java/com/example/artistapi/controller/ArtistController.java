package com.example.artistapi.controller;

import com.example.artistapi.controller.dto.request.ArtistSubscriptionApiRequest;
import com.example.artistapi.controller.dto.request.ArtistUnsubscriptionApiRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/artists")
@Tag(name = "아티스트")
public class ArtistController {

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
