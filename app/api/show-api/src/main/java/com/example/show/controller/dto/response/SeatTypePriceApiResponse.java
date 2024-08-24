package com.example.show.controller.dto.response;

public record SeatTypePriceApiResponse(
    String seatType,
    int price
) {
    public static SeatTypePriceApiResponse of(String seatType, int price) {
        return new SeatTypePriceApiResponse(seatType, price);
    }

}
