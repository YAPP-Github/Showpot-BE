package com.example.show.controller.dto.param;

public record SeatTypePriceApiParam(
    String seatType,
    int price
) {
    public static SeatTypePriceApiParam of(String seatType, int price) {
        return new SeatTypePriceApiParam(seatType, price);
    }

}
