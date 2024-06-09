package org.example.security.dto;

import java.util.Map;
import java.util.UUID;
import lombok.Builder;
import org.example.vo.UserRole;
import org.example.vo.UserRoleApiType;

@Builder
public record UserParam(
    UUID userId,
    UserRoleApiType role
) {

    public Map<String, String> getTokenClaim() {
        return Map.of(
            "userId", userId.toString(),
            "role", role.name()
        );
    }

    public static UserParam fromPayload(Object payload) {
        Map<String, String> claim = (Map<String, String>) payload;

        return UserParam.builder()
            .userId(UUID.fromString(claim.get("userId")))
            .role(UserRoleApiType.valueOf(claim.get("role")))
            .build();
    }

    public static UserParam as(UUID userId, UserRole userRole) {
        return new UserParam(userId, UserRoleApiType.valueOf(userRole.name()));
    }
}
