package com.example.mq;

import com.example.mq.message.ArtistSubscriptionServiceMessage;
import com.example.mq.message.GenreSubscriptionServiceMessage;
import com.example.mq.message.ShowRelationArtistAndGenreServiceMessage;
import com.example.mq.message.TicketingReservationServiceMessage;

public interface MessagePublisher {

    void publishShow(String topic, ShowRelationArtistAndGenreServiceMessage message);

    void publishArtistSubscription(String topic, ArtistSubscriptionServiceMessage message);

    void publishGenreSubscription(String topic, GenreSubscriptionServiceMessage message);

    void publishTicketingReservation(String topic, TicketingReservationServiceMessage message);
}
