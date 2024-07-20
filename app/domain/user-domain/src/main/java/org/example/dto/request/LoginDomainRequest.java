package org.example.dto.request;

import lombok.Builder;
import org.example.vo.SocialLoginType;

@Builder
public record LoginDomainRequest(
    SocialLoginType socialLoginType,
    String identifier,
    String fcmToken
) {

}
