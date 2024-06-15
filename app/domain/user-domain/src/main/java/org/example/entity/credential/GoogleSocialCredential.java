package org.example.entity.credential;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public final class GoogleSocialCredential extends SocialCredential {

    public GoogleSocialCredential(String basicIdentifier) {
        super(basicIdentifier);
    }
}

