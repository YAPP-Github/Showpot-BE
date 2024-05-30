package org.example.security.dto;

import java.util.Map;
import java.util.UUID;
import org.example.vo.UserRoleApiType;

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
}
