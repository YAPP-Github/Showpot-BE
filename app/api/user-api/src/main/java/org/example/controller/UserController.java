package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.controller.dto.request.LoginApiRequest;
import org.example.controller.dto.response.LoginApiResponse;
import org.example.controller.dto.response.ReissueApiResponse;
import org.example.controller.dto.response.UserProfileApiResponse;
import org.example.security.dto.AuthenticatedUser;
import org.example.security.dto.TokenParam;
import org.example.service.UserService;
import org.example.util.ParseToken;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
        @RequestHeader(value = "Authorization") String accessToken
    ) {
        userService.logout(user.userId(), ParseToken.getAccessToken(accessToken));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/withdrawal")
    @Operation(summary = "회원탈퇴")
    public ResponseEntity<Void> withdraw(
        @AuthenticationPrincipal AuthenticatedUser user,
        @RequestHeader(value = "Authorization") String accessToken
    ) {
        userService.withdraw(user.userId(), ParseToken.getAccessToken(accessToken));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/reissue")
    @Operation(summary = "토큰 재발급")
    public ResponseEntity<ReissueApiResponse> reissue(
        @AuthenticationPrincipal AuthenticatedUser user,
        @RequestHeader(value = "Refresh") String refreshToken
    ) {
        TokenParam reissueToken = userService.reissue(user.userId(), refreshToken);

        return ResponseEntity.ok(
            ReissueApiResponse.builder()
                .accessToken(reissueToken.accessToken())
                .refreshToken(reissueToken.refreshToken())
                .build()
        );
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
