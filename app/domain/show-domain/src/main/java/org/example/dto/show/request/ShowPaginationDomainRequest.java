package org.example.dto.show.request;

import java.util.UUID;
import lombok.Builder;
import org.example.vo.ShowSortType;

@Builder
public record ShowPaginationDomainRequest(
    ShowSortType sort,
    boolean onlyOpenSchedule,
    UUID cursor,
    int size
) {

}
