package com.example.show.controller.dto.request;

import com.example.show.service.dto.request.ShowAlertPaginationServiceRequest;
import com.example.show.vo.ShowTicketingAtStatusApiType;
import io.swagger.v3.oas.annotations.Parameter;
import java.time.LocalDateTime;
import java.util.UUID;

public record ShowAlertPaginationApiRequest(

    @Parameter(description = "페이지네이션 데이터 개수", required = true)
    int size,

    @Parameter(description = "공연 티켓팅 상태 타입", required = true)
    ShowTicketingAtStatusApiType type,

    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId,

    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorValue / 최초 조회라면 null")
    LocalDateTime cursorValue
) {

    public ShowAlertPaginationServiceRequest toServiceRequest(UUID userId) {
        return ShowAlertPaginationServiceRequest.builder()
            .userId(userId)
            .size(size)
            .type(type)
            .cursorId(cursorId)
            .cursorValue(cursorValue)
            .build();
    }
}
