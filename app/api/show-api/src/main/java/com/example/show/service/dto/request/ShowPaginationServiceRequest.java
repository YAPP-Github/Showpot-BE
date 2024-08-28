package com.example.show.service.dto.request;

import com.example.show.controller.vo.ShowSortApiType;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.show.request.ShowPaginationDomainRequest;

@Builder
public record ShowPaginationServiceRequest(
    ShowSortApiType sort,
    boolean onlyOpenSchedule,
    UUID cursorId,
    int size
) {

    public ShowPaginationDomainRequest toDomainRequest(LocalDateTime now) {
        return ShowPaginationDomainRequest.builder()
            .sort(sort.toDomainType())
            .onlyOpenSchedule(onlyOpenSchedule)
            .cursorId(cursorId)
            .size(size)
            .now(now)
            .build();
    }
}
