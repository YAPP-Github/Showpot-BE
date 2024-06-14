package org.example.entity.credential;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public final class KakaoSocialCredential extends SocialCredential {

    public KakaoSocialCredential(String basicIdentifier) {
        super(basicIdentifier);
    }
}
