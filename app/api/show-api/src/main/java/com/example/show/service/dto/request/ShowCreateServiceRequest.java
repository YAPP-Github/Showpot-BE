package com.example.show.service.dto.request;

import com.example.show.controller.dto.response.SeatInfoApiResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.Builder;
import org.example.entity.show.Show;
import org.example.entity.show.info.SeatPrices;
import org.example.entity.show.info.TicketingSites;
import org.springframework.web.multipart.MultipartFile;

@Builder
public record ShowCreateServiceRequest(

    String title,
    String content,
    LocalDate startDate,
    LocalDate endDate,
    String location,
    MultipartFile post,
    SeatInfoApiResponse seatInfoApiResponse,
    Map<String, String> showTicketingSiteInfos,
    List<UUID> artistIds,
    List<UUID> genreIds
) {

    public Show toShowWithImageUrl(String imageUrl) {
        TicketingSites ticketingSites = new TicketingSites();
        showTicketingSiteInfos.forEach(ticketingSites::saveTicketingSite);

        return Show.builder()
            .title(title)
            .content(content)
            .startDate(startDate)
            .endDate(endDate)
            .location(location)
            .image(imageUrl)
            .seatPrices(getSeatPrice())
            .ticketingSites(ticketingSites)
            .build();
    }

    private SeatPrices getSeatPrice() {
        SeatPrices seatPrices = new SeatPrices();
        seatInfoApiResponse.priceInformation().forEach(seatPrices::savePriceInformation);

        return seatPrices;
    }
}
