package org.example.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.example.service.dto.request.LoginServiceRequest;
import org.example.vo.SocialLoginApiType;

public record LoginApiRequest(

    @Schema(description = "소셜 로그인 타입")
    @NotNull(message = "소셜 로그인 타입은 필수 입력값입니다.")
    SocialLoginApiType socialType,

    @Schema(description = "소셜 로그인 식별자")
    @NotNull(message = "소셜 로그인 식별값은 필수 입력값입니다.")
    String identifier,

    @Schema(description = "FCM 토큰")
    @NotNull(message = "FCM 토큰은 필수 입력값입니다.")
    String fcmToken
) {

    public LoginServiceRequest toServiceType() {
        return LoginServiceRequest.builder()
            .socialLoginType(socialType)
            .identifier(identifier)
            .fcmToken(fcmToken)
            .build();
    }
}
