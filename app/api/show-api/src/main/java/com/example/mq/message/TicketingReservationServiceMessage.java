package com.example.mq.message;

import java.util.List;

public record TicketingReservationServiceMessage(
    String userFcmToken,
    List<ReserveShowServiceMessage> reserveShows
) {

}
