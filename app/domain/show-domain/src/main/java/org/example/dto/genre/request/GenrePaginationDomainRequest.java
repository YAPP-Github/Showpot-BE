package org.example.dto.genre.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.vo.SubscriptionStatus;

@Builder
public record GenrePaginationDomainRequest(
    SubscriptionStatus subscriptionStatus,
    UUID cursor,
    int size,
    List<UUID> genreIds
) {

}
