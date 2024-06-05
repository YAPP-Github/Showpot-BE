package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dto.request.SignUpRequest;
import org.example.entity.User;
import org.example.security.dto.TokenParam;
import org.example.service.UserService;
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

    @PostMapping("/sign-up")
    @Operation(summary = "유저 로그인", description = "사용자는 소셜 로그인을 할 수 있다.", tags = {"user"})
    public ResponseEntity<TokenParam> signUp(@Valid @RequestBody SignUpRequest request) {
        final User createdUser = request.toUser();
        TokenParam tokenParam = userService.signUp(createdUser);

        return ResponseEntity.ok(tokenParam);
    }

}
