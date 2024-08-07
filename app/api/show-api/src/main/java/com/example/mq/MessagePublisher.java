package com.example.mq;

import com.example.show.service.dto.request.SubscriptionMessageServiceRequest;

public interface MessagePublisher {

    void publish(String topic, SubscriptionMessageServiceRequest request);
}
