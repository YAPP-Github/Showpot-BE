package org.example.vo;

public enum SocialLoginApiType {
    GOOGLE, KAKAO, APPLE;

    public SocialLoginType toDomainType() {
        return switch (this) {
            case GOOGLE -> SocialLoginType.GOOGLE;
            case KAKAO -> SocialLoginType.KAKAO;
            case APPLE -> SocialLoginType.APPLE;
        };
    }
}
