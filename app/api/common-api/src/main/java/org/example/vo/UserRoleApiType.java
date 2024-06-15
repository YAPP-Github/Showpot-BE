package org.example.vo;

import lombok.Getter;
import org.example.entity.User;

@Getter
public enum UserRoleApiType {
    GUEST("ROLE_GUEST"),
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    final String authority;

    UserRoleApiType(String authority) {
        this.authority = authority;
    }

    public static UserRoleApiType from(User user) {
        return UserRoleApiType.valueOf(user.getUserRole().name());
    }
}
