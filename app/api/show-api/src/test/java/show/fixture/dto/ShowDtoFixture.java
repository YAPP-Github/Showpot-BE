package show.fixture.dto;

import com.example.show.controller.dto.response.SeatInfoApiResponse;
import com.example.show.service.dto.request.ShowCreateServiceRequest;
import com.example.show.service.dto.request.ShowUpdateServiceRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.mock.web.MockMultipartFile;

public class ShowDtoFixture {

    private static final MockMultipartFile post = new MockMultipartFile(
        "image",
        "test_image.jpg",
        "image/jpeg",
        "test image content".getBytes()
    );

    public static ShowCreateServiceRequest showCreateServiceRequest() {
        return ShowCreateServiceRequest.builder()
            .title("test_title")
            .content("test_content")
            .startDate(LocalDate.EPOCH)
            .endDate(LocalDate.EPOCH)
            .location("test_location")
            .post(post)
            .seatInfoApiResponse(getSeatInfoApiResponse())
            .showTicketingSiteInfos(getTicketingInfoApiResponse())
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
            .seatInfoApiResponse(getSeatInfoApiResponse())
            .showTicketingSiteInfos(getTicketingInfoApiResponse())
            .artistIds(List.of(UUID.randomUUID()))
            .genreIds(List.of(UUID.randomUUID()))
            .build();
    }

    private static SeatInfoApiResponse getSeatInfoApiResponse() {
        return new SeatInfoApiResponse(
            Map.of(
                "VIP", 150000,
                "R", 120000,
                "S", 100000,
                "A", 80000
            )
        );
    }

    private static Map<String, String> getTicketingInfoApiResponse() {
        return Map.of(
            "YES24", "https://YES24URL",
            "인터파크", "https://인터파크URL"
        );
    }
}
