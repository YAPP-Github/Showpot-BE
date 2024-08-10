package org.example.fixture;

import java.util.UUID;
import org.example.entity.SocialLogin;
import org.example.vo.SocialLoginType;

public class SocialLoginFixture {

    public static SocialLogin socialLogin(SocialLoginType type, UUID userId) {
        return SocialLogin.builder()
            .socialLoginType(type)
            .identifier("testIdentifier")
            .userId(userId)
            .build();
    }
}
