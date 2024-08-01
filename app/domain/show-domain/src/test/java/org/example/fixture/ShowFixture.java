package org.example.fixture;

import java.time.LocalDate;
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
            .build();
    }

    private static SeatPrice getSeatPrice() {
        return new SeatPrice();
    }
}
