package org.example.entity.credential;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.vo.SocialLoginType;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public sealed class SocialCredential permits AppleSocialCredential, GoogleSocialCredential,
    KakaoSocialCredential {

    private SocialLoginType socialLoginType;
    private String basicIdentifier;

}
