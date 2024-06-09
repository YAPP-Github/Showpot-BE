package org.example.entity.credential;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;
import org.example.vo.SocialLoginType;
import org.hibernate.annotations.Type;

@Embeddable
public final class SocialCredentials {

    @Type(JsonType.class)
    @Column(name = "social_credentials", columnDefinition = "jsonb", nullable = false)
    private final List<SocialCredential> socialCredentials = new ArrayList<>();

    public void put(SocialLoginType socialLoginType, String socialIdentifier) {
        SocialCredential socialCredential = getSocialCredential(socialLoginType, socialIdentifier);
        socialCredentials.add(socialCredential);
    }

    private SocialCredential getSocialCredential(
        SocialLoginType socialLoginType,
        String socialIdentifier
    ) {
        SocialCredential socialCredential;
        switch (socialLoginType) {
            case GOOGLE -> socialCredential = new GoogleSocialCredential();
            case KAKAO -> socialCredential = new KakaoSocialCredential();
            case APPLE -> socialCredential = new AppleSocialCredential();
            default -> socialCredential = null;
        }
        socialCredential.put(socialLoginType, socialIdentifier);
        return socialCredential;
    }

}