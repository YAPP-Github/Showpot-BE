package org.example.dto.response;

import org.example.vo.SocialLoginType;

public record UserProfileDomainResponse(
    String nickname,
    SocialLoginType type
) {

}
