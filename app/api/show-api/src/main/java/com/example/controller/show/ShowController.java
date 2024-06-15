package com.example.controller.show;

import com.example.controller.show.dto.response.ShowInterestApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shows")
@Tag(name = "공연")
public class ShowController {

    @PostMapping("{showId}/interest")
    @Operation(summary = "공연 관심 등록 / 취소")
    public ResponseEntity<ShowInterestApiResponse> interest(
        @Parameter(name = "공연 ID") @PathVariable("showId") UUID showId
    ) {
        return ResponseEntity.ok(
            new ShowInterestApiResponse(true)
        );
    }
}
