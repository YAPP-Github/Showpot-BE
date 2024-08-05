package genre.fixture;

import com.example.genre.service.dto.request.GenreSubscriptionPaginationServiceRequest;
import com.example.genre.service.dto.request.GenreUnsubscriptionPaginationServiceRequest;
import com.example.vo.SubscriptionStatusApiType;
import java.util.UUID;

public class GenreRequestDtoFixture {

    public static GenreSubscriptionPaginationServiceRequest genrePaginationServiceRequest(
        int size
    ) {
        return GenreSubscriptionPaginationServiceRequest.builder()
            .subscriptionStatusApiType(SubscriptionStatusApiType.SUBSCRIBED)
            .cursor(UUID.randomUUID())
            .size(size)
            .userId(UUID.randomUUID())
            .build();
    }

    public static GenreUnsubscriptionPaginationServiceRequest genreUnsubscriptionPaginationServiceRequest(
        int size
    ) {
        return GenreUnsubscriptionPaginationServiceRequest.builder()
            .subscriptionStatusApiType(SubscriptionStatusApiType.UNSUBSCRIBED)
            .cursor(UUID.randomUUID())
            .size(size)
            .userId(UUID.randomUUID())
            .build();
    }

}
