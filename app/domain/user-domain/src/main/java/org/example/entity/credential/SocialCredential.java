package org.example.entity.credential;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.Map;

public sealed interface SocialCredential permits AppleSocialCredential, GoogleSocialCredential,
    KakaoSocialCredential {


    @JsonAnySetter
    void put(Object socialLoginType, String socialIdentifier);

    @JsonAnyGetter
    Map<Object, String> getCredentialMap();


}
