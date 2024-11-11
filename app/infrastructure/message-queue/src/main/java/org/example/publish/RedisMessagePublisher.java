package org.example.publish;

import com.example.pub.MessagePublisher;
import com.example.pub.message.ArtistSubscriptionServiceMessage;
import com.example.pub.message.GenreSubscriptionServiceMessage;
import com.example.pub.message.ShowRelationArtistAndGenreServiceMessage;
import com.example.pub.message.TicketingAlertsToReserveServiceMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.message.ArtistSubscriptionInfraMessage;
import org.example.message.GenreSubscriptionInfraMessage;
import org.example.message.ShowRelationArtistAndGenreInfraMessage;
import org.example.message.TicketingReservationInfraMessage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisMessagePublisher implements MessagePublisher {

    private final RedisTemplate<String, Object> template;

    @Override
    public void publishShow(String topic, ShowRelationArtistAndGenreServiceMessage message) {
        var infraMessage = ShowRelationArtistAndGenreInfraMessage.from(message);
        publishMessage(topic, infraMessage);
    }

    @Override
    public void publishArtistSubscription(String topic, ArtistSubscriptionServiceMessage message) {
        var infraMessage = ArtistSubscriptionInfraMessage.from(message);
        publishMessage(topic, infraMessage);
    }

    @Override
    public void publishGenreSubscription(String topic, GenreSubscriptionServiceMessage message) {
        var infraMessage = GenreSubscriptionInfraMessage.from(message);
        publishMessage(topic, infraMessage);
    }

    @Override
    public void publishTicketingReservation(String topic, TicketingAlertsToReserveServiceMessage message) {
        var infraMessage = TicketingReservationInfraMessage.from(message);
        publishMessage(topic, infraMessage);
    }

    private void publishMessage(String topic, Object infraMessage) {
        template.convertAndSend(topic, infraMessage);
        log.info("Message published successfully to topic: {}", topic);
        log.info("Message Contents ( {} : {} )", infraMessage.getClass().getName(), infraMessage);
    }
}
