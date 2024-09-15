package com.example.show.controller.dto.usershow.response;


import com.example.show.service.dto.usershow.response.NumberOfTicketingAlertServiceResponse;

public record NumberOfTicketingAlertApiResponse(
    long count
) {

    public static NumberOfTicketingAlertApiResponse from(
        NumberOfTicketingAlertServiceResponse response
    ) {
        return new NumberOfTicketingAlertApiResponse(response.count());
    }
}
