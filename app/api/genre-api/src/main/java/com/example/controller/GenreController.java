package com.example.controller;

import com.example.controller.dto.request.GenreSubscriptionApiRequest;
import com.example.controller.dto.request.GenreUnsubscriptionApiRequest;
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
@RequestMapping("/api/v1/genres")
@Tag(name = "장르")
public class GenreController {

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
