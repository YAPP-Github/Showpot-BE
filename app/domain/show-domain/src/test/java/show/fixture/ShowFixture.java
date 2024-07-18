package show.fixture;

import java.time.LocalDate;
import org.example.entity.show.Show;
import org.example.entity.show.info.SeatPrice;
import org.example.entity.show.info.Ticketing;

public class ShowFixture {

    public static Show show() {
        return Show.builder()
            .title("test_title")
            .content("test_content")
            .date(LocalDate.EPOCH)
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
        return new Ticketing();
    }
}
