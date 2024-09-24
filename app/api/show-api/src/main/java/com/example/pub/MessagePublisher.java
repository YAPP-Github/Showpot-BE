package com.example.pub;

import com.example.pub.message.ArtistSubscriptionServiceMessage;
import com.example.pub.message.GenreSubscriptionServiceMessage;
import com.example.pub.message.ShowRelationArtistAndGenreServiceMessage;
import com.example.pub.message.TicketingAlertsToReserveServiceMessage;

public interface MessagePublisher {

    void publishShow(String topic, ShowRelationArtistAndGenreServiceMessage message);

    void publishArtistSubscription(String topic, ArtistSubscriptionServiceMessage message);

    void publishGenreSubscription(String topic, GenreSubscriptionServiceMessage message);

    void publishTicketingReservation(String topic, TicketingAlertsToReserveServiceMessage message);
}
