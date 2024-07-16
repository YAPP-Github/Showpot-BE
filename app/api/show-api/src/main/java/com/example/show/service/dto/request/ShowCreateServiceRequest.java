package com.example.show.service.dto.request;

import com.example.show.controller.dto.response.SeatInfoApiResponse;
import com.example.show.controller.dto.response.TicketingInfoApiResponse;
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
    SeatInfoApiResponse seatInfoApiResponse,
    TicketingInfoApiResponse ticketingInfoApiResponse,
    List<UUID> artistIds,
    List<UUID> genreIds
) {

    public Show toShowWithImageUrl(String imageUrl) {
        return Show.builder()
            .title(title)
            .content(content)
            .date(date)
            .location(location)
            .image(imageUrl)
            .seatPrice(getSeatPrice())
            .ticketing(getTicketing())
            .build();
    }

    private SeatPrice getSeatPrice() {
        SeatPrice seatPrice = new SeatPrice();
        seatInfoApiResponse.priceInformation().forEach(seatPrice::savePriceInformation);

        return seatPrice;
    }

    private Ticketing getTicketing() {
        Ticketing ticketing = new Ticketing();
        ticketing.saveTicketOpenTime(ticketingInfoApiResponse.ticketOpenTime());
        ticketingInfoApiResponse.ticketingInformation().forEach(ticketing::saveTicketingInformation);

        return ticketing;
    }

}
