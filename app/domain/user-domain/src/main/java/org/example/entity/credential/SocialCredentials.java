package org.example.entity.credential;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.HashMap;
import java.util.Map;
import org.example.vo.SocialLoginType;
import org.hibernate.annotations.Type;

@Embeddable
public class SocialCredentials {

    @Type(JsonType.class)
    @Column(name = "social_credentials", columnDefinition = "jsonb", nullable = false)
    private Map<SocialLoginType, SocialCredential> socialLoginTypeCredentials = new HashMap<>();

    public void saveCredentials(SocialLoginType socialLoginType, SocialCredential socialCredential) {
        socialLoginTypeCredentials.put(socialLoginType, socialCredential);
    }
}
