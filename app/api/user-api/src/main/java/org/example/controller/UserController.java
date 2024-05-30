package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dto.request.SignUpRequest;
import org.example.entity.User;
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
    @Operation(summary = "유저 회원가입", description = "사용자는 회원가입을 할 수 있다.", tags = {"user"})
    public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequest request) {
        final User createdUser = request.toUser();
        final User user = userService.signUp(createdUser);
        final String nickName = userService.findNickname(user);

        return ResponseEntity.ok(nickName + "사용자 생성 성공!");
    }

}
