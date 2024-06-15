package org.example.controller.dto.response;

public record LoginApiResponse(
    String accessToken,
    String refreshToken
) {
}
