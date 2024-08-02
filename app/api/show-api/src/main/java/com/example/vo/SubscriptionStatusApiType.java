package com.example.vo;

import org.example.vo.SubscriptionStatus;

public enum SubscriptionStatusApiType {
    SUBSCRIBED,
    UNSUBSCRIBED;

    public SubscriptionStatus toDomainType() {
        return switch (this) {
            case SUBSCRIBED -> SubscriptionStatus.SUBSCRIBED;
            case UNSUBSCRIBED -> SubscriptionStatus.UNSUBSCRIBED;
        };
    }
}
