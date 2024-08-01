package org.example.fixture;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.example.entity.show.Show;
import org.example.entity.show.info.SeatPrice;
import org.example.entity.show.info.Ticketing;

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
            .ticketing(getTicketing())
            .build();
    }

    private static SeatPrice getSeatPrice() {
        return new SeatPrice();
    }

    private static Ticketing getTicketing() {
        Ticketing ticketing = new Ticketing();
        ticketing.saveTicketOpenTime(LocalDateTime.of(LocalDate.EPOCH, LocalTime.MIDNIGHT));
        return ticketing;
    }
}
