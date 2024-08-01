package genre.fixture;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.example.dto.genre.response.GenreSubscriptionDomainResponse;
import org.example.dto.genre.response.GenreSubscriptionPaginationDomainResponse;
import org.example.dto.genre.response.GenreUnsubscriptionDomainResponse;
import org.example.dto.genre.response.GenreUnsubscriptionPaginationDomainResponse;

public class GenreResponseDtoFixture {

    public static GenreSubscriptionPaginationDomainResponse genreSubscriptionPaginationDomainResponse(
        int size,
        boolean hasNext
    ) {
        return GenreSubscriptionPaginationDomainResponse.builder()
            .data(genreSubscriptionDomainResponses(size))
            .hasNext(hasNext)
            .build();
    }

    public static GenreUnsubscriptionPaginationDomainResponse genreUnsubscriptionPaginationDomainResponse(
        int size,
        boolean hasNext
    ) {
        return GenreUnsubscriptionPaginationDomainResponse.builder()
            .data(genreUnsubscriptionDomainResponses(size))
            .hasNext(hasNext)
            .build();
    }

    public static List<GenreSubscriptionDomainResponse> genreSubscriptionDomainResponses(int size) {
        return IntStream.range(0, size)
            .mapToObj(i -> GenreSubscriptionDomainResponse.builder()
                .id(UUID.randomUUID())
                .name("testName" + i)
                .build())
            .toList();
    }

    public static List<GenreUnsubscriptionDomainResponse> genreUnsubscriptionDomainResponses(
        int size
    ) {
        return IntStream.range(0, size)
            .mapToObj(i -> GenreUnsubscriptionDomainResponse.builder()
                .id(UUID.randomUUID())
                .name("testName" + i)
                .build())
            .toList();
    }
}
