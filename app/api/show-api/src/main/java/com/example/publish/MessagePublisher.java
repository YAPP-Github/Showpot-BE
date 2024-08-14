package com.example.publish;

import com.example.publish.message.ArtistSubscriptionServiceMessage;
import com.example.publish.message.GenreSubscriptionServiceMessage;
import com.example.publish.message.ShowRelationArtistAndGenreServiceMessage;
import com.example.publish.message.TicketingAlertsToReserveServiceMessage;

public interface MessagePublisher {

    void publishShow(String topic, ShowRelationArtistAndGenreServiceMessage message);

    void publishArtistSubscription(String topic, ArtistSubscriptionServiceMessage message);

    void publishGenreSubscription(String topic, GenreSubscriptionServiceMessage message);

    void publishTicketingReservation(String topic, TicketingAlertsToReserveServiceMessage message);
}
