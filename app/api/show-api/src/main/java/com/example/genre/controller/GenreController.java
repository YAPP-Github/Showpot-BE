package com.example.genre.controller;

import com.example.genre.controller.dto.request.GenrePaginationApiRequest;
import com.example.genre.controller.dto.request.GenreSubscriptionApiRequest;
import com.example.genre.controller.dto.request.GenreUnsubscriptionApiRequest;
import com.example.genre.controller.dto.response.GenrePaginationApiResponse;
import com.example.genre.controller.dto.response.GenreSimpleApiResponse;
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
@RequestMapping("/api/v1/genres")
@Tag(name = "장르")
public class GenreController {

    @GetMapping
    @Operation(summary = "장르 목록 조회")
    public ResponseEntity<GenrePaginationApiResponse> getGenres(
        @RequestParam(required = false) GenrePaginationApiRequest param
    ) {
        String image = "https://thumb.mtstarnews.com/06/2023/06/2023062914274537673_1.jpg";
        return ResponseEntity.ok(
            new GenrePaginationApiResponse(
                List.of(
                    new GenreSimpleApiResponse(
                        UUID.randomUUID(),
                        "힙합",
                        image
                    ),
                    new GenreSimpleApiResponse(
                        UUID.randomUUID(),
                        "발라드",
                        image
                    ),
                    new GenreSimpleApiResponse(
                        UUID.randomUUID(),
                        "시티팝",
                        image
                    )
                ),
                false
            )
        );
    }

    @PostMapping("/subscribe")
    @Operation(summary = "구독하기")
    public ResponseEntity<Void> subscribe(
        @Valid @RequestBody GenreSubscriptionApiRequest request
    ) {
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/unsubscribe")
    @Operation(summary = "구독 취소하기")
    public ResponseEntity<Void> unsubscribe(
        @Valid @RequestBody GenreUnsubscriptionApiRequest request
    ) {
        return ResponseEntity.noContent().build();
    }
}
