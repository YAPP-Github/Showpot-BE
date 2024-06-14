package org.example.entity.credential;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract sealed class SocialCredential permits AppleSocialCredential, GoogleSocialCredential,
    KakaoSocialCredential {

    private String basicIdentifier;
}
