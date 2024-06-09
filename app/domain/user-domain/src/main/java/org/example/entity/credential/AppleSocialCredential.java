package org.example.entity.credential;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class AppleSocialCredential implements SocialCredential {

    private final Map<Object, String> credentialMap = new HashMap<>();

    @Override
    public void put(Object socialLoginType, String socialIdentifier) {
        credentialMap.put(socialLoginType, socialIdentifier);
    }

    @Override
    public Map<Object, String> getCredentialMap() {
        return credentialMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppleSocialCredential that = (AppleSocialCredential) o;
        return Objects.equals(getCredentialMap(), that.getCredentialMap());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCredentialMap());
    }
}
