package org.example.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import org.example.controller.dto.LoginApiDto;
import org.example.entity.credential.AppleSocialCredential;
import org.example.entity.credential.GoogleSocialCredential;
import org.example.entity.credential.KakaoSocialCredential;
import org.example.entity.credential.SocialCredential;
import org.example.entity.credential.SocialCredentials;
import org.example.vo.SocialLoginType;

public record LoginApiRequest(
    @NotNull(message = "소셜 로그인 타입은 필수 입력값입니다.")
    SocialLoginType socialLoginType,

    @NotNull(message = "소셜 로그인 식별값은 필수 입력값입니다.")
    String socialLoginIdentifier
) {

    public LoginApiDto toLoginApiDto() {
        return LoginApiDto.builder()
            .socialCredentials(socialCredentials())
            .build();
    }

    private SocialCredentials socialCredentials() {
        SocialCredentials socialCredentials = new SocialCredentials();
        socialCredentials.saveCredentials(socialLoginType, socialCredential());
        return socialCredentials;
    }

    private SocialCredential socialCredential() {
        return switch (socialLoginType) {
            case GOOGLE -> new GoogleSocialCredential(socialLoginIdentifier);
            case KAKAO -> new KakaoSocialCredential(socialLoginIdentifier);
            case APPLE -> new AppleSocialCredential(socialLoginIdentifier);
        };
    }
}
