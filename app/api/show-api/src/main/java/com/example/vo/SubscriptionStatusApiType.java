package com.example.vo;

import org.example.vo.SubscriptionStatus;

public enum SubscriptionStatusApiType {
    SUBSCRIBED,
    UNSUBSCRIBED,
    DEFAULTED;

    public SubscriptionStatus toDomainType() {
        return switch (this) {
            case SUBSCRIBED -> SubscriptionStatus.SUBSCRIBED;
            case UNSUBSCRIBED -> SubscriptionStatus.UNSUBSCRIBED;
            case DEFAULTED -> SubscriptionStatus.DEFAULTED;
        };
    }
}
