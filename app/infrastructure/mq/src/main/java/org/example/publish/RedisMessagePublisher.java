package org.example.publish;

import com.example.mq.MessagePublisher;
import com.example.show.service.dto.request.SubscriptionMessageServiceRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.message.SubscriptionMessageInfraRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisMessagePublisher implements MessagePublisher {

    private final RedisTemplate<String, Object> template;

    @Override
    public void publish(String topic, SubscriptionMessageServiceRequest apiRequest) {
        template.convertAndSend(topic, SubscriptionMessageInfraRequest.from(apiRequest));
        log.info("Message published successfully to topic: {}", topic);
        log.info("Message Contents ( artistIds : {}, genreIds : {} )",
            apiRequest.artistIds(),
            apiRequest.genreIds()
        );
    }
}
