package org.example.dto.request;

import jakarta.validation.constraints.NotNull;
import org.example.entity.User;

public record SignUpRequest(

    @NotNull(message = "닉네임은 필수 입력값입니다.")
    String nickname
) {

    public User toUser() {
        return new User(nickname);
    }
}
