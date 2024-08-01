package org.example.fixture;

import java.time.LocalDate;
import java.util.Map;
import org.example.entity.show.Show;
import org.example.entity.show.info.SeatPrice;

public class ShowFixture {

    public static Show deafultShow() {
        return Show.builder()
            .title("test_title")
            .content("test_content")
            .startDate(LocalDate.EPOCH)
            .endDate(LocalDate.EPOCH)
            .location("test_location")
            .image("test_image")
            .seatPrice(getSeatPrice())
            .ticketingSiteInfo(getTicketingInfos())
            .build();
    }

    private static SeatPrice getSeatPrice() {
        return new SeatPrice();
    }

    private static Map<String, String> getTicketingInfos() {
        return Map.of(
            "YES24", "https://YES24URL",
            "인터파크", "https://인터파크URL"
        );
    }
}
