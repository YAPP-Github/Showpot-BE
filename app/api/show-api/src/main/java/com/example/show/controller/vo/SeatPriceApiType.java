package com.example.show.controller.vo;

import java.util.Map;
import org.example.entity.show.info.SeatPrice;

public record SeatPriceApiType(
    Map<String, Integer> priceInformation
) {

    public static SeatPriceApiType from(SeatPrice seatPrice) {
        return new SeatPriceApiType(seatPrice.getPriceInformation());
    }


}
