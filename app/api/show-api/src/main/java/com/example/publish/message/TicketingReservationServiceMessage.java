package com.example.publish.message;

import java.util.List;

public record TicketingReservationServiceMessage(
    String userFcmToken,
    List<ReserveShowServiceMessage> reserveShows
) {

}
