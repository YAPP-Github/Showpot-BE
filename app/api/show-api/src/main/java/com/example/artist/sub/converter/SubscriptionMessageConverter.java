package com.example.artist.sub.converter;

import com.example.artist.sub.message.ArtistWithGenreCreateMessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;

@Slf4j
public class SubscriptionMessageConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static ArtistWithGenreCreateMessageRequest toArtistCreateMessage(Message message) {
        try {
            var convertedMessage = objectMapper.readValue(
                message.getBody(),
                ArtistWithGenreCreateMessageRequest.class
            );
            log.info("Message published successfully to topic: {}",
                new String(message.getChannel()));
            log.info("Subscribe Message Contents ( ArtistWithGenreCreateMessageRequest : {} )", message);

            return convertedMessage;
        } catch (IOException e) {
            log.error("Failed to convert message to ArtistWithGenreCreateMessageRequest", e);
            throw new IllegalArgumentException("메시지를 받지 못했습니다.");
        }
    }
}
