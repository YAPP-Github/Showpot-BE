package org.example.fixture.dto;

import org.example.service.dto.request.LoginServiceRequest;
import org.example.vo.SocialLoginApiType;

public class UserRequestDtoFixture {

    public static LoginServiceRequest loginServiceRequest(SocialLoginApiType type) {
        return LoginServiceRequest.builder()
            .socialLoginType(type)
            .fcmToken("testFcmToken")
            .identifier("testIdentifier")
            .build();
    }
}
