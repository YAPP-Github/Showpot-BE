package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.ShowSeatServiceResponse;
import java.util.Map;

public record ShowSeatApiResponse(
    Map<String, Integer> priceBySeat
) {

    public static ShowSeatApiResponse from(ShowSeatServiceResponse seats) {
        return new ShowSeatApiResponse(seats.priceBySeat());
    }
}
