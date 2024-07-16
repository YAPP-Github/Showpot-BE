package com.example.show.controller.dto.response;

import java.util.Map;
import org.example.entity.show.info.SeatPrice;

public record SeatInfoApiResponse(
    Map<String, Integer> priceInformation
) {

    public static SeatInfoApiResponse from(SeatPrice seatPrice) {
        return new SeatInfoApiResponse(seatPrice.getPriceInformation());
    }


}
