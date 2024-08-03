package org.example.fixture;

import java.time.LocalDate;
import java.util.Map;
import org.example.entity.show.Show;
import org.example.entity.show.info.SeatPrices;
import org.example.entity.show.info.TicketingSites;

public class ShowFixture {

    public static Show deafultShow() {
        return Show.builder()
            .title("test_title")
            .content("test_content")
            .startDate(LocalDate.EPOCH)
            .endDate(LocalDate.EPOCH)
            .location("test_location")
            .image("test_image")
            .seatPrices(getSeatPrice())
            .ticketingSites(getTicketingInfos())
            .build();
    }

    private static SeatPrices getSeatPrice() {
        return new SeatPrices();
    }

    private static TicketingSites getTicketingInfos() {
        TicketingSites ticketingSites = new TicketingSites();

        Map.of(
            "YES24", "https://YES24URL",
            "인터파크", "https://인터파크URL"
        ).forEach(ticketingSites::saveTicketingSite);

        return ticketingSites;
    }
}
