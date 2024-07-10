package org.example.controller.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.service.dto.request.AdminLoginServiceRequest;

public record AdminLoginApiRequest(

    @Email(message = "이메일 형식이 아닙니다.")
    @NotNull(message = "이메일은 필수 입력값입니다.")
    String email,

    @Size(min = 8, max = 20, message = "비밀번호는 최소 8자 이상, 최대 20자 이하이어야 합니다.")
    @NotNull(message = "비밀번호는 필수 입력값입니다.")
    String password
) {

    public AdminLoginServiceRequest toServiceRequest() {
        return new AdminLoginServiceRequest(email, password);
    }

}
