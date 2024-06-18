package org.example.entity.credential;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.HashMap;
import java.util.Map;
import org.example.vo.SocialLoginType;
import org.hibernate.annotations.Type;

@Embeddable
public class SocialLoginCredential {

    @Type(JsonType.class)
    @Column(name = "social_login_credential", columnDefinition = "jsonb", nullable = false)
    private Map<SocialLoginType, SocialCredential> socialLoginTypeCredential = new HashMap<>();

    public void saveCredentials(SocialLoginType socialLoginType, SocialCredential socialCredential) {
        socialLoginTypeCredential.put(socialLoginType, socialCredential);
    }
}
