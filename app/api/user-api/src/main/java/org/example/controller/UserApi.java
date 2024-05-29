package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.example.dto.request.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserApi {

    @Operation(
        summary = "유저 회원가입",
        description = "사용자는 회원가입을 할 수 있다.",
        tags = {"user"}
    )
    ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequest request);

}
