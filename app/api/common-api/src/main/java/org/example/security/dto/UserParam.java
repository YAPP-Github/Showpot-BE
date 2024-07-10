package org.example.security.dto;

import java.util.Map;
import java.util.UUID;
import lombok.Builder;
import org.example.entity.User;
import org.example.vo.UserRoleApiType;

@Builder
public record UserParam(
    UUID userId,
    UserRoleApiType role
) {

    public static UserParam fromPayload(Object payload) {
        Map<String, String> claim = (Map<String, String>) payload;

        return UserParam.builder()
            .userId(UUID.fromString(claim.get("userId")))
            .role(UserRoleApiType.valueOf(claim.get("role")))
            .build();
    }

    public static UserParam from(User user) {
        return UserParam.builder()
            .userId(user.getId())
            .role(UserRoleApiType.from(user.getUserRole()))
            .build();
    }

    public Map<String, String> getTokenClaim() {
        return Map.of(
            "userId", userId.toString(),
            "role", role.name()
        );
    }
}
