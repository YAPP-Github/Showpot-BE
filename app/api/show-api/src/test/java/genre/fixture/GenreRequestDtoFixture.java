package genre.fixture;

import com.example.genre.service.dto.request.GenreSubscriptionPaginationServiceRequest;
import com.example.genre.service.dto.request.GenreUnsubscriptionPaginationServiceRequest;
import java.util.UUID;

public class GenreRequestDtoFixture {

    public static GenreSubscriptionPaginationServiceRequest genreSubscriptionPaginationServiceRequest(
        int size
    ) {
        return GenreSubscriptionPaginationServiceRequest.builder()
            .cursor(UUID.randomUUID())
            .size(size)
            .userId(UUID.randomUUID())
            .build();
    }

    public static GenreUnsubscriptionPaginationServiceRequest genreUnsubscriptionPaginationServiceRequest(
        int size
    ) {
        return GenreUnsubscriptionPaginationServiceRequest.builder()
            .cursor(UUID.randomUUID())
            .size(size)
            .userId(UUID.randomUUID())
            .build();
    }

}
