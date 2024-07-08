package org.example.vo;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

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

    public List<GrantedAuthority> getAdminAuthority() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(ADMIN.authority));

        return authorities;
    }
}
