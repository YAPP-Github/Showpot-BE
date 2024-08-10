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

    public static SocialLoginApiType from(SocialLoginType type) {
        return switch (type) {
            case GOOGLE -> SocialLoginApiType.GOOGLE;
            case KAKAO -> SocialLoginApiType.KAKAO;
            case APPLE -> SocialLoginApiType.APPLE;
        };
    }
}
