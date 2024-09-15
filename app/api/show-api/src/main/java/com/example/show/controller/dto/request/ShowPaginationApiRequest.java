package com.example.show.controller.dto.request;

import com.example.show.controller.vo.ShowSortApiType;
import com.example.show.service.dto.request.ShowPaginationServiceRequest;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Max;
import java.util.UUID;
import org.springdoc.core.annotations.ParameterObject;

@ParameterObject
public record ShowPaginationApiRequest(

    @Parameter(required = true, description = "정렬 방향")
    ShowSortApiType sort,

    @Parameter(required = true, description = "오픈예정 티켓만 보기")
    boolean onlyOpenSchedule,

    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId,

    @Parameter(example = "30")
    @Max(value = 30, message = "조회하는 데이터의 최대 개수는 30입니다.")
    Integer size
) {
    public ShowPaginationApiRequest {
        if (size == null) {
            size = 30;
        }
    }

    public ShowPaginationServiceRequest toServiceRequest() {
        return ShowPaginationServiceRequest.builder()
            .sort(sort)
            .onlyOpenSchedule(onlyOpenSchedule)
            .cursorId(cursorId)
            .size(size)
            .build();
    }
}
