package show.fixture.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.IntStream;
import org.example.dto.show.response.ShowDetailDomainResponse;
import org.example.dto.show.response.ShowDomainResponse;
import org.example.dto.show.response.ShowSearchDomainResponse;
import org.example.dto.show.response.ShowSearchPaginationDomainResponse;
import org.example.entity.show.info.SeatPrices;
import org.example.entity.show.info.TicketingSites;

public class ShowResponseDtoFixture {

    public static ShowDetailDomainResponse showDetailDomainResponse() {
        return ShowDetailDomainResponse.builder()
            .show(showDomainResponse())
            .artists(Set.of())
            .genres(Set.of())
            .showTicketingTimes(Set.of())
            .build();
    }

    public static ShowDomainResponse showDomainResponse() {
        return ShowDomainResponse.builder()
            .id(UUID.randomUUID())
            .title("testTile")
            .content("testContent")
            .startDate(LocalDate.now())
            .endDate(LocalDate.now())
            .location("testLocation")
            .image("testImage")
            .lastTicketingAt(LocalDateTime.now())
            .viewCount(0)
            .seatPrices(new SeatPrices())
            .ticketingSites(new TicketingSites())
            .build();
    }

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
                .startAt(LocalDate.EPOCH)
                .endAt(LocalDate.EPOCH)
                .location("testLocation")
                .image("testImage")
                .build()
            )
            .toList();
    }
}
