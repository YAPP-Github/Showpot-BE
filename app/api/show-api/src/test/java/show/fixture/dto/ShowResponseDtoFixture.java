package show.fixture.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.example.dto.show.response.ShowSearchDomainResponse;
import org.example.dto.show.response.ShowSearchPaginationDomainResponse;

public class ShowResponseDtoFixture {

    public static ShowSearchPaginationDomainResponse showSearchPaginationDomainResponse(
        int size,
        boolean hasNext
    ) {
        return ShowSearchPaginationDomainResponse.builder()
            .data(showSearchDomainResponses(size))
            .hasNext(hasNext)
            .build();
    }

    public static ShowSearchPaginationDomainResponse emptyDataShowSearchPaginationDomainResponse() {
        return ShowSearchPaginationDomainResponse.builder()
            .data(List.of())
            .hasNext(false)
            .build();
    }

    public static List<ShowSearchDomainResponse> showSearchDomainResponses(int size) {
        return IntStream.range(0, size)
            .mapToObj(i -> ShowSearchDomainResponse.builder()
                .id(UUID.randomUUID())
                .title("testTitle")
                .startDate(LocalDate.EPOCH)
                .endDate(LocalDate.EPOCH)
                .location("testLocation")
                .image("testImage")
                .build()
            )
            .toList();
    }
}
