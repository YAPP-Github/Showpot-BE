package com.example.show.service.dto.response;

import java.util.Map;
import lombok.Builder;
import org.example.entity.show.info.SeatPrices;

@Builder
public record ShowSeatServiceResponse(
    Map<String, Integer> priceBySeat
) {

    public static ShowSeatServiceResponse from(SeatPrices seatPrices) {
        return new ShowSeatServiceResponse(seatPrices.getPriceBySeat());
    }
}
