package org.example.security.dto;

import java.util.UUID;
import lombok.Builder;
import org.example.vo.UserRoleApiType;

@Builder
public record AuthenticatedInfo(
    String accessToken,
    String refreshToken,
    UUID userId,
    UserRoleApiType role
) {

    public static AuthenticatedInfo getUserWithAccessToken(
        UserParam userParam,
        String accessToken
    ) {
        return AuthenticatedInfo.builder()
            .userId(userParam.userId())
            .role(userParam.role())
            .accessToken(accessToken)
            .build();
    }

    public static AuthenticatedInfo getUserWithRefreshToken(
        UserParam userParam,
        String refreshToken
    ) {
        return AuthenticatedInfo.builder()
            .refreshToken(refreshToken)
            .userId(userParam.userId())
            .role(userParam.role())
            .build();
    }
}
