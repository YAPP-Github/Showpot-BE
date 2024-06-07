package org.example.vo;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.annotations.Type;

@Embeddable
public final class SocialCredentials {

    @Type(JsonType.class)
    @Column(name = "social_credentials", columnDefinition = "jsonb", nullable = false)
    private final Map<SocialLoginType, String> socialCredentials = new HashMap<>();

    public void put(SocialLoginType socialLoginType, String socialIdentifier) {
        socialCredentials.put(socialLoginType, socialIdentifier);
    }
}
