package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.ShowSeatServiceResponse;
import com.example.show.service.dto.response.ShowTicketingSiteServiceResponse;
import com.example.show.service.dto.response.ShowTicketingTimeServiceResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.example.dto.show.response.ShowTicketingTimeDomainResponse;
import org.example.dto.show.response.ShowWithTicketingTimesDomainResponse;

public record ShowWithTicketingTimesServiceResponse(
    UUID id,
    String title,
    String content,
    LocalDate startDate,
    LocalDate endDate,
    String location,
    String image,
    ShowSeatServiceResponse seats,
    ShowTicketingSiteServiceResponse ticketingSiteInfos,
    List<ShowTicketingTimeServiceResponse> ticketingTimes
) {

    public ShowWithTicketingTimesServiceResponse(
        ShowWithTicketingTimesDomainResponse domainResponse) {
        this(
            domainResponse.show().id(),
            domainResponse.show().title(),
            domainResponse.show().content(),
            domainResponse.show().startDate(),
            domainResponse.show().endDate(),
            domainResponse.show().location(),
            domainResponse.show().image(),
            ShowSeatServiceResponse.from(domainResponse.show().seatPrices()),
            ShowTicketingSiteServiceResponse.from(domainResponse.show().ticketingSites()),
            toShowTicketingTimeServiceResponses(domainResponse.ticketingTimes())
        );
    }

    private static List<ShowTicketingTimeServiceResponse> toShowTicketingTimeServiceResponses(
        List<ShowTicketingTimeDomainResponse> ticketingSites
    ) {
        return ticketingSites.stream()
            .map(ShowTicketingTimeServiceResponse::from)
            .toList();
    }

}
