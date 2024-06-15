package org.example.security.dto;

import java.util.UUID;
import lombok.Builder;
import org.example.vo.UserRoleApiType;

@Builder
public record AuthenticatedUser(
    UUID userId,
    UserRoleApiType role
) {

}
