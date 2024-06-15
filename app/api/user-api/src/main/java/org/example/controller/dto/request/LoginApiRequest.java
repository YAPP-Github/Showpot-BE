package org.example.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import org.example.controller.vo.SocialLoginApiType;

public record LoginApiRequest(
    @NotNull(message = "소셜 로그인 타입은 필수 입력값입니다.")
    SocialLoginApiType socialType,

    @NotNull(message = "소셜 로그인 식별값은 필수 입력값입니다.")
    String identifier,

    @NotNull(message = "소셜 로그인 식별값은 필수 입력값입니다.")
    String fcmToken
) {

}
