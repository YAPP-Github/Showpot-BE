package org.example.publish;

import com.example.mq.MessagePublisher;
import com.example.mq.message.ArtistSubscriptionServiceMessage;
import com.example.mq.message.GenreSubscriptionServiceMessage;
import com.example.mq.message.ShowRelationArtistAndGenreServiceMessage;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.message.ArtistSubscriptionInfraMessage;
import org.example.message.GenreSubscriptionInfraMessage;
import org.example.message.ShowRelationArtistAndGenreInfraMessage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisMessagePublisher implements MessagePublisher {

    private final RedisTemplate<String, Object> template;

    @Override
    public void publishShow(String topic, ShowRelationArtistAndGenreServiceMessage message) {
        template.convertAndSend(topic, ShowRelationArtistAndGenreInfraMessage.from(message));
        log.info("Message published successfully to topic: {}", topic);
        log.info("Message Contents ( artistIds : {}, genreIds : {} )",
            message.artistIds(),
            message.genreIds()
        );
    }

    @Override
    public void publishArtistSubscription(
        String topic,
        List<ArtistSubscriptionServiceMessage> messages
    ) {
        var infraMessages = messages.stream()
            .map(ArtistSubscriptionInfraMessage::from)
            .toList();

        template.convertAndSend(topic, infraMessages);
        log.info("Message published successfully to topic: {}", topic);
        log.info("Message Contents ( artistSubscriptionMessage : {} )", infraMessages);
    }

    @Override
    public void publishGenreSubscription(
        String topic,
        List<GenreSubscriptionServiceMessage> messages
    ) {
        var infraMessages = messages.stream()
            .map(GenreSubscriptionInfraMessage::from)
            .toList();

        template.convertAndSend(topic, infraMessages);
        log.info("Message published successfully to topic: {}", topic);
        log.info("Message Contents ( genreSubscriptionMessage : {} )", infraMessages);
    }
}
