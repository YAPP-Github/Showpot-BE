package com.example.show.controller;

import com.example.artist.controller.dto.response.ArtistSimpleApiResponse;
import com.example.genre.controller.dto.response.GenreSimpleApiResponse;
import com.example.show.controller.dto.request.ShowInterestPaginationApiRequest;
import com.example.show.controller.dto.request.ShowPaginationApiRequest;
import com.example.show.controller.dto.response.ShowDetailApiResponse;
import com.example.show.controller.dto.response.ShowInterestApiResponse;
import com.example.show.controller.dto.response.ShowInterestPaginationApiResponse;
import com.example.show.controller.dto.response.ShowPaginationApiResponse;
import com.example.show.controller.dto.response.ShowSimpleApiResponse;
import com.example.show.controller.dto.response.TicketingAndShowInfoApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shows")
@Tag(name = "공연")
public class ShowController {

    private String image = "https://thumb.mtstarnews.com/06/2023/06/2023062914274537673_1.jpg";

    @GetMapping
    @Operation(summary = "공연 목록 조회")
    public ResponseEntity<ShowPaginationApiResponse> getShows(
        @RequestParam(required = false) ShowPaginationApiRequest param
    ) {
        return ResponseEntity.ok(
            new ShowPaginationApiResponse(
                List.of(
                    new ShowSimpleApiResponse(
                        UUID.randomUUID(),
                        "2021 서울재즈페스티벌",
                        new ArtistSimpleApiResponse(
                            UUID.randomUUID(),
                            "윈터",
                            image
                        ),
                        new GenreSimpleApiResponse(
                            UUID.randomUUID(),
                            "재즈",
                            image
                        ),
                        List.of(
                            new TicketingAndShowInfoApiResponse(
                                "2021-10-01 14:00:00",
                                "2021-10-03 14:00:00",
                                image
                            )
                        ),
                        image
                    )
                ),
                false
            )
        );
    }

    @PostMapping("{showId}/interest")
    @Operation(summary = "공연 관심 등록 / 취소")
    public ResponseEntity<ShowInterestApiResponse> interest(
        @Parameter(name = "공연 ID") @PathVariable("showId") UUID showId
    ) {
        return ResponseEntity.ok(
            new ShowInterestApiResponse(true)
        );
    }

    @GetMapping("/interests")
    @Operation(summary = "공연 관심 목록 조회")
    public ResponseEntity<ShowInterestPaginationApiResponse> getInterests(
        @RequestParam(required = false) ShowInterestPaginationApiRequest param
    ) {
        return ResponseEntity.ok(
            new ShowInterestPaginationApiResponse(
                List.of(
                    new ShowSimpleApiResponse(
                        UUID.randomUUID(),
                        "2021 서울재즈페스티벌",
                        new ArtistSimpleApiResponse(
                            UUID.randomUUID(),
                            "윈터",
                            image
                        ),
                        new GenreSimpleApiResponse(
                            UUID.randomUUID(),
                            "재즈",
                            image
                        ),
                        List.of(
                            new TicketingAndShowInfoApiResponse(
                                "2021-10-01 14:00:00",
                                "2021-10-03 14:00:00",
                                image
                            )
                        ),
                        image
                    )
                ),
                false
            )
        );
    }

    @GetMapping("{showId}")
    @Operation(summary = "공연 상세 조회")
    public ResponseEntity<ShowDetailApiResponse> getShow(
        @Parameter(name = "공연 ID") @PathVariable("showId") UUID showId
    ) {
        return ResponseEntity.ok(
            new ShowDetailApiResponse(
                showId,
                "2021 서울재즈페스티벌",
                new ArtistSimpleApiResponse(
                    UUID.randomUUID(),
                    "윈터",
                    image
                ),
                new GenreSimpleApiResponse(
                    UUID.randomUUID(),
                    "재즈",
                    image
                ),
                List.of(
                    new TicketingAndShowInfoApiResponse(
                        "2021-10-01 14:00:00",
                        "2021-10-03 14:00:00",
                        image
                    )
                ),
                image
            )
        );
    }

    @PostMapping("{showId}/alert")
    @Operation(summary = "공연 알림 등록 / 취소")
    public ResponseEntity<Void> alert(
        @Parameter(name = "공연 ID") @PathVariable("showId") UUID showId
    ) {
        return ResponseEntity.noContent().build();
    }
}
