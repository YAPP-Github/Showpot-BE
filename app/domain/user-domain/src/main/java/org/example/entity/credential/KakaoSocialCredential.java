package org.example.entity.credential;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.vo.SocialLoginType;

@Getter
@NoArgsConstructor
public final class KakaoSocialCredential extends SocialCredential {

    public KakaoSocialCredential(SocialLoginType  socialLoginType, String basicIdentifier) {
        super(socialLoginType, basicIdentifier);
    }
}
