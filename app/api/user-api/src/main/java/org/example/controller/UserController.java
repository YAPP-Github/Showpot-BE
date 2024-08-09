package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.controller.dto.request.LoginApiRequest;
import org.example.controller.dto.request.LogoutApiRequest;
import org.example.controller.dto.request.WithdrawalApiRequest;
import org.example.controller.dto.response.LoginApiResponse;
import org.example.controller.dto.response.UserProfileApiResponse;
import org.example.security.dto.AuthenticatedUser;
import org.example.security.dto.TokenParam;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "유저")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    @Operation(summary = "로그인", description = "회원가입 / 로그인")
    public ResponseEntity<LoginApiResponse> signUp(@Valid @RequestBody LoginApiRequest request) {
        TokenParam token = userService.login(request.toServiceType());

        return ResponseEntity.ok(
            LoginApiResponse.builder()
                .accessToken(token.accessToken())
                .refreshToken(token.refreshToken())
                .build()
        );
    }

    @PostMapping("/logout")
    @Operation(summary = "로그아웃")
    public ResponseEntity<Void> logout(
        @AuthenticationPrincipal AuthenticatedUser user,
        @RequestBody LogoutApiRequest request
    ) {
        userService.logout(request.toServiceRequest(user.userId()));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/withdrawal")
    @Operation(summary = "회원탈퇴")
    public ResponseEntity<Void> withdraw(
        @AuthenticationPrincipal AuthenticatedUser user,
        @RequestBody WithdrawalApiRequest request
    ) {
        userService.withdraw(request.toServiceRequest(user.userId()));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/profile")
    @Operation(summary = "회원 정보")
    public ResponseEntity<UserProfileApiResponse> profile(
        @AuthenticationPrincipal AuthenticatedUser user
    ) {
        var profile = userService.findUserProfile(user.userId());

        return ResponseEntity.ok(
            UserProfileApiResponse.from(profile)
        );
    }
}
