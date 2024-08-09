package com.example.mq;

import com.example.mq.message.ArtistSubscriptionServiceMessage;
import com.example.mq.message.GenreSubscriptionServiceMessage;
import com.example.mq.message.ShowRelationArtistAndGenreServiceMessage;
import java.util.List;

public interface MessagePublisher {

    void publishShow(String topic, ShowRelationArtistAndGenreServiceMessage message);

    void publishArtistSubscription(String topic, List<ArtistSubscriptionServiceMessage> messages);

    void publishGenreSubscription(String topic, List<GenreSubscriptionServiceMessage> messages);
}
