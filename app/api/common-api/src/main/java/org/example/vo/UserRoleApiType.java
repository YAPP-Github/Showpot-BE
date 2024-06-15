package org.example.vo;

import lombok.Getter;

@Getter
public enum UserRoleApiType {
    GUEST("ROLE_GUEST"),
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    final String authority;

    UserRoleApiType(String authority) {
        this.authority = authority;
    }

    public static UserRoleApiType from(UserRole userRole) {
        return UserRoleApiType.valueOf(userRole.name());
    }
}
