package com.example.show.controller.dto.request;

import com.example.show.controller.vo.ShowSortApiType;
import com.example.show.service.dto.request.ShowPaginationServiceRequest;
import io.swagger.v3.oas.annotations.Parameter;
import java.util.UUID;
import org.springdoc.core.annotations.ParameterObject;

@ParameterObject
public record ShowPaginationApiRequest(

    @Parameter(required = true, description = "정렬 방향")
    ShowSortApiType sort,

    @Parameter(required = true, description = "오픈예정 티켓만 보기")
    boolean onlyOpenSchedule,

    @Parameter(description = "이전 페이지네이션 마지막 데이터의 ID / 최초 조회라면 null")
    UUID cursorId,

    @Parameter(required = true, description = "조회하려는 데이터 개수")
    int size
) {

    public ShowPaginationServiceRequest toServiceRequest() {
        return ShowPaginationServiceRequest.builder()
            .sort(sort)
            .onlyOpenSchedule(onlyOpenSchedule)
            .cursorId(cursorId)
            .size(size)
            .build();
    }
}
