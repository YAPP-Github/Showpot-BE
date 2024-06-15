package org.example.entity.credential;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public final class AppleSocialCredential extends SocialCredential {

    public AppleSocialCredential(String basicIdentifier) {
        super(basicIdentifier);
    }
}
