package com.example.mq;

public interface MessagePublisher {

    void publish(String topic, SubscriptionMessageApiRequest request);
}
