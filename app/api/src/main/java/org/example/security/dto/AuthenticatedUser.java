package org.example.security.dto;

import java.util.UUID;
import org.example.vo.UserRoleApiType;

public record AuthenticatedUser(
    UUID userId,
    UserRoleApiType role
) {

}
