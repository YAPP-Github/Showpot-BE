package genre.fixture;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.example.dto.genre.response.GenreDomainResponse;
import org.example.dto.genre.response.GenrePaginationDomainResponse;

public class GenreResponseDtoFixture {

    public static GenrePaginationDomainResponse genrePaginationDomainResponse(
        int size,
        boolean hasNext
    ) {
        return GenrePaginationDomainResponse.builder()
            .data(genreDomainResponses(size))
            .hasNext(hasNext)
            .build();
    }

    public static List<GenreDomainResponse> genreDomainResponses(int size) {
        return IntStream.range(0, size)
            .mapToObj(i -> GenreDomainResponse.builder()
                .id(UUID.randomUUID())
                .name("testName" + i)
                .build())
            .toList();
    }
}
