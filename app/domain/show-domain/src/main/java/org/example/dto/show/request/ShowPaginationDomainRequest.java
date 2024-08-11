package org.example.dto.show.request;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import org.example.vo.ShowSortType;

@Builder
public record ShowPaginationDomainRequest(
    ShowSortType sort,
    boolean onlyOpenSchedule,
    UUID cursorId,
    Object cursorValue,
    int size,
    LocalDateTime now
) {

}
