package com.example.artist.sub.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.util.ErrorHandler;

@Configuration
@RequiredArgsConstructor
public class SubscriptionMessageConfig {

    private final MessageListener artistCreateListener;
    private final ErrorHandler redisSubErrorHandler;

    @Bean
    MessageListenerAdapter artistCreateListenerAdapter() {
        return new MessageListenerAdapter(artistCreateListener);
    }

    @Bean
    RedisMessageListenerContainer registerShowMessageListenerContainer(
        RedisConnectionFactory connectionFactory,
        MessageListenerAdapter artistCreateListenerAdapter
    ) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(
            artistCreateListenerAdapter,
            ChannelTopic.of("createArtist")
        );
        container.setErrorHandler(redisSubErrorHandler);
        return container;
    }
}
