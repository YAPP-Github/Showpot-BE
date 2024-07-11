package com.example.show.service.dto.request;

import com.example.show.controller.vo.SeatPriceApiType;
import com.example.show.controller.vo.TicketingApiType;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.entity.show.Show;
import org.example.entity.show.info.SeatPrice;
import org.example.entity.show.info.Ticketing;
import org.springframework.web.multipart.MultipartFile;

@Builder
public record ShowCreateServiceRequest(

    String title,
    String content,
    LocalDate date,
    String location,
    MultipartFile post,
    SeatPriceApiType seatPriceApiType,
    TicketingApiType ticketingApiType,
    List<UUID> artistIds,
    List<UUID> genreIds
) {

    public Show toShow(String image) {
        return Show.builder()
            .title(title)
            .content(content)
            .date(date)
            .location(location)
            .image(image)
            .seatPrice(getSeatPrice())
            .ticketing(getTicketing())
            .build();
    }

    private SeatPrice getSeatPrice() {
        SeatPrice seatPrice = new SeatPrice();
        seatPriceApiType.priceInformation().forEach(seatPrice::savePriceInformation);

        return seatPrice;
    }

    private Ticketing getTicketing() {
        Ticketing ticketing = new Ticketing();
        ticketing.saveTicketOpenTime(ticketingApiType.ticketOpenTime());
        ticketingApiType.ticketingInformation().forEach(ticketing::saveTicketingInformation);

        return ticketing;
    }

}
