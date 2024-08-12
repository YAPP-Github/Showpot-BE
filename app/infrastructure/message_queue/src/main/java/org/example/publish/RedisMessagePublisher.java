package org.example.publish;

import com.example.mq.MessagePublisher;
import com.example.mq.message.ArtistSubscriptionServiceMessage;
import com.example.mq.message.GenreSubscriptionServiceMessage;
import com.example.mq.message.ShowRelationArtistAndGenreServiceMessage;
import com.example.mq.message.TicketingReservationServiceMessage;
import java.util.List;
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

        template.convertAndSend(topic, infraMessage);
        log.info("Message published successfully to topic: {}", topic);
        log.info("Message Contents ( showRelationArtistAndGenreInfraMessage : {})", infraMessage);
    }

    @Override
    public void publishArtistSubscription(
        String topic,
        ArtistSubscriptionServiceMessage message
    ) {
        var infraMessage = ArtistSubscriptionInfraMessage.from(message);

        template.convertAndSend(topic, infraMessage);
        log.info("Message published successfully to topic: {}", topic);
        log.info("Message Contents ( artistSubscriptionMessage : {} )", infraMessage);
    }

    @Override
    public void publishGenreSubscription(
        String topic,
        GenreSubscriptionServiceMessage message
    ) {
        var infraMessage = GenreSubscriptionInfraMessage.from(message);

        template.convertAndSend(topic, infraMessage);
        log.info("Message published successfully to topic: {}", topic);
        log.info("Message Contents ( genreSubscriptionMessage : {} )", infraMessage);
    }

    @Override
    public void publishTicketingReservation(
        String topic,
        List<TicketingReservationServiceMessage> messages
    ) {
        var infraMessages = messages.stream()
            .map(TicketingReservationInfraMessage::from)
            .toList();

        template.convertAndSend(topic, infraMessages);
        log.info("Message published successfully to topic: {}", topic);
        log.info("Message Contents ( ticketingReservationMessage : {} )", infraMessages);
    }
}
