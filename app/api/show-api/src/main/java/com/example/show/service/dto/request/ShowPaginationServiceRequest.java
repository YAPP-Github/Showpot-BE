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
    UUID cursor,
    int size,
    LocalDateTime now
) {

    public ShowPaginationDomainRequest toDomainRequest() {
        return ShowPaginationDomainRequest.builder()
            .sort(sort.toDomainType())
            .onlyOpenSchedule(onlyOpenSchedule)
            .cursor(cursor)
            .size(size)
            .now(now)
            .build();
    }
}
