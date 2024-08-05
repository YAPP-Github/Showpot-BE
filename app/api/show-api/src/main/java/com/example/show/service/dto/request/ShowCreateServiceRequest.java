package com.example.show.service.dto.request;

import com.example.show.controller.vo.TicketingApiType;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.show.request.ShowCreationDomainRequest;
import org.example.entity.show.info.SeatPrices;
import org.example.entity.show.info.ShowTicketingTimes;
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
    Map<String, Integer> priceInformation,
    Map<String, String> showTicketingSites,
    Map<TicketingApiType, LocalDate> ticketingTimes,
    List<UUID> artistIds,
    List<UUID> genreIds
) {

    public ShowCreationDomainRequest toDomainRequest(String imageURL) {
        return ShowCreationDomainRequest.builder()
            .title(title)
            .content(content)
            .startDate(startDate)
            .endDate(endDate)
            .location(location)
            .posterImageURL(imageURL)
            .showSeats(getSeatPrice())
            .showTicketingSites(getTicketingSites())
            .showTicketingTimes(getTicketingTimes())
            .artistIds(artistIds)
            .genreIds(genreIds)
            .build();
    }

    private SeatPrices getSeatPrice() {
        SeatPrices seatPrices = new SeatPrices();
        priceInformation.forEach(seatPrices::savePriceInformation);

        return seatPrices;
    }

    private TicketingSites getTicketingSites() {
        TicketingSites ticketingSites = new TicketingSites();
        showTicketingSites.forEach(ticketingSites::saveTicketingSite);

        return ticketingSites;
    }

    private ShowTicketingTimes getTicketingTimes() {
        ShowTicketingTimes showTicketingTimes = new ShowTicketingTimes();
        ticketingTimes.forEach(
            (apiType, date) ->
                showTicketingTimes.saveTicketingTimes(
                    apiType.toDomainType(),
                    date
                )
        );
        return showTicketingTimes;
    }
}
