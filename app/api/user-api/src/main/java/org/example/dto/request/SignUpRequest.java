package org.example.dto.request;

import jakarta.validation.constraints.NotNull;
import org.example.entity.User;

public record SignUpRequest(

    @NotNull
    String nickname
) {

    public User toUser() {
        return new User(nickname);
    }
}
