package show.fixture.dto;

import com.example.show.controller.dto.response.SeatInfoApiResponse;
import com.example.show.controller.vo.TicketingApiType;
import com.example.show.service.dto.request.ShowCreateServiceRequest;
import com.example.show.service.dto.request.ShowSearchPaginationServiceRequest;
import com.example.show.service.dto.request.ShowUpdateServiceRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.mock.web.MockMultipartFile;

public class ShowRequestDtoFixture {

    private static final MockMultipartFile post = new MockMultipartFile(
        "image",
        "test_image.jpg",
        "image/jpeg",
        "test posterImageURL content".getBytes()
    );

    public static ShowCreateServiceRequest showCreateServiceRequest() {
        return ShowCreateServiceRequest.builder()
            .title("test_title")
            .content("test_content")
            .startDate(LocalDate.EPOCH)
            .endDate(LocalDate.EPOCH)
            .location("test_location")
            .post(post)
            .priceInformation(getSeatInfoApiResponse())
            .showTicketingSites(getTicketingSites())
            .ticketingTimes(getShowTicketingDates())
            .artistIds(List.of(UUID.randomUUID()))
            .genreIds(List.of(UUID.randomUUID()))
            .build();
    }

    public static ShowUpdateServiceRequest showUpdateServiceRequest() {
        return ShowUpdateServiceRequest.builder()
            .title("test_title")
            .content("test_content")
            .startDate(LocalDate.EPOCH)
            .endDate(LocalDate.EPOCH)
            .location("test_location")
            .post(post)
            .seatInfoApiResponse(getSeatInfoApiResponses())
            .showTicketingSiteInfos(getTicketingSites())
            .artistIds(List.of(UUID.randomUUID()))
            .genreIds(List.of(UUID.randomUUID()))
            .build();
    }

    public static ShowSearchPaginationServiceRequest showSearchPaginationServiceRequest(
        int size,
        String search
    ) {
        return ShowSearchPaginationServiceRequest.builder()
            .cursor(UUID.randomUUID())
            .size(size)
            .search(search)
            .build();
    }

    private static Map<String, Integer> getSeatInfoApiResponse() {
        return Map.of(
            "VIP", 150000,
            "R", 120000,
            "S", 100000,
            "A", 80000
        );
    }

    private static SeatInfoApiResponse getSeatInfoApiResponses() {
        return new SeatInfoApiResponse(
            Map.of(
                "VIP", 150000,
                "R", 120000,
                "S", 100000,
                "A", 80000
            )
        );
    }

    private static Map<String, String> getTicketingSites() {
        return Map.of(
            "YES24", "https://YES24URL",
            "인터파크", "https://인터파크URL"
        );
    }

    private static Map<TicketingApiType, LocalDate> getShowTicketingDates() {
        return Map.of(
            TicketingApiType.PRE, LocalDate.of(2024, 10, 1),
            TicketingApiType.NORMAL, LocalDate.of(2024, 10, 12)
        );
    }
}
