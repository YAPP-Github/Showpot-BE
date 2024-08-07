package org.example.message;

import com.example.show.service.dto.request.SubscriptionMessageServiceRequest;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record SubscriptionMessageInfraRequest(
    List<UUID> artistIds,
    List<UUID> genreIds
) {

    public static SubscriptionMessageInfraRequest from(SubscriptionMessageServiceRequest apiRequest) {
        return SubscriptionMessageInfraRequest.builder()
            .artistIds(apiRequest.artistIds())
            .genreIds(apiRequest.genreIds())
            .build();

    }
}
