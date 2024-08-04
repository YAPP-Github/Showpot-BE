package com.example.show.controller.dto.response;

import java.util.Map;
import org.example.entity.show.info.SeatPrices;

public record SeatInfoApiResponse(
    Map<String, Integer> priceInformation
) {

    public static SeatInfoApiResponse from(SeatPrices seatPrices) {
        return new SeatInfoApiResponse(seatPrices.getPriceBySeat());
    }
}
