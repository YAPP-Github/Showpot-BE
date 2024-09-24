package com.example.artist.sub.converter;

import com.example.artist.sub.message.ArtistCreateMessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;

@Slf4j
public class SubscriptionMessageConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static ArtistCreateMessageRequest toArtistCreateMessage(Message message) {
        try {
            var convertedMessage = objectMapper.readValue(
                message.getBody(),
                ArtistCreateMessageRequest.class
            );
            log.info("Message published successfully to topic: {}",
                new String(message.getChannel()));
            log.info("Subscribe Message Contents ( ArtistCreateServiceRequest : {} )", message);

            return convertedMessage;
        } catch (IOException e) {
            log.error("Failed to convert message to ArtistCreateServiceRequest", e);
            throw new IllegalArgumentException("메시지를 받지 못했습니다.");
        }
    }
}
