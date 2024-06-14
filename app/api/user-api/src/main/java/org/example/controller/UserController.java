package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.controller.dto.request.LoginApiRequest;
import org.example.security.dto.TokenParam;
import org.example.service.UserService;
import org.example.service.dto.request.LoginServiceRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0.0.1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    @Tag(name = "user")
    @Operation(summary = "유저 로그인", description = "사용자는 소셜 로그인을 할 수 있다.")
    public ResponseEntity<TokenParam> signUp(@Valid @RequestBody LoginApiRequest request) {
        final LoginServiceRequest loginServiceRequest = request.toLoginApiDto()
            .toLoginServiceRequest();
        TokenParam tokenParam = userService.login(loginServiceRequest);

        return ResponseEntity.ok(tokenParam);
    }

}
