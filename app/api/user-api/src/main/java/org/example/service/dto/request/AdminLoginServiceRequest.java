package org.example.service.dto.request;

import org.example.entity.Admin;

public record AdminLoginServiceRequest(
    String email,
    String password
) {

    public Admin toAdmin() {
        return Admin.builder()
            .email(email)
            .password(password)
            .build();
    }
}
